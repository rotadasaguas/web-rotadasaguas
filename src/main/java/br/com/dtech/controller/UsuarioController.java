package br.com.dtech.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dtech.dao.ProfileDao;
import br.com.dtech.dao.UsuarioDao;
import br.com.dtech.dao.utils.DAOFactory;
import br.com.dtech.model.Profile;
import br.com.dtech.model.Usuario;
import br.com.dtech.utils.security.GenerateMD5;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Set<String> ROLE_COMMON;

	public UsuarioController() {
		super();
	}

	private void tratarRequisicao(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		String ac = request.getParameter("acao");

		if (ac.equals("login")) {
			logar(request, response);
		} else if (ac.equals("iniciar_login")) {
			iniciarLogin(request, response);
		} else if (ac.equals("sair")) {
			sair(request, response);
		}
		else if (ac.equals("error")) {
			error(request, response);
		}
	}

	private void sair(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		RequestDispatcher rd = request.getRequestDispatcher("/publica/login_usuario.jsp");

		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private void iniciarLogin(HttpServletRequest request,
			HttpServletResponse response) {
		RequestDispatcher rd = request
				.getRequestDispatcher("/publica/login_usuario.jsp");

		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private void error(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = request
				.getRequestDispatcher("/publica/login_usuario.jsp?acao=error");

		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void logar(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter("user");
		String senha = request.getParameter("password");
		
		

		UsuarioDao usuarioDao = DAOFactory.criarUsuario();
		ProfileDao profileDao = DAOFactory.criarProfile();
		
		Usuario usuario = new Usuario();
		Profile profile = new Profile();
		
		try {
			usuario = usuarioDao.login(login, GenerateMD5.generate(senha));
			profile = profileDao.buscarPerfil(usuario.getId());
		} catch (Exception e) {
			System.out.println("Conta não encontrada");
			error(request, response);
		}
		

		if (usuario != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("usuario", usuario);
			session.setAttribute("profile", profile);
			
			RequestDispatcher rd;
			
			
			if(!usuario.getPermissions().equals(ROLE_COMMON)){
				
				if(usuario.getLocais().size() != 0){
					rd = request.getRequestDispatcher("/empreendedor/meus_locais.jsp");
				}
				else{
					rd = request.getRequestDispatcher("/empreendedor/home.jsp");
				}
			}else{
				rd = request.getRequestDispatcher("/admin/home.jsp");
				System.out.println(usuario.getPermissions());
			}
	
			try {
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("não logado");
		}
	}

	

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		tratarRequisicao(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		tratarRequisicao(request, response);
	}

}