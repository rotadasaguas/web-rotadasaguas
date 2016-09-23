package br.com.dtech.controller;

import java.io.IOException;

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
import br.com.dtech.model.*;
import br.com.dtech.utils.Role;
import br.com.dtech.utils.security.GenerateMD5;

@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProfileController() {
		super();
	}

	private void tratarRequisicao(HttpServletRequest request,
			HttpServletResponse response) {

		String ac = request.getParameter("acao");

		if (ac.equals("salvar")) {
			salvar(request, response);
		}

	}
	
	private void salvar(HttpServletRequest request, HttpServletResponse response) {
		
		boolean tentativa = false;
		
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");		
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		
		
		try{
			Profile profile = new Profile();
			Usuario usuario = new Usuario();
			
			
			profile.setCelular(telefone);
			profile.setCpf(cpf);
			profile.setNome(nome);
			profile.setEmail(email);
			usuario.getPermissions().add(Role.ROLE_COMMON.getValue());
			
			usuario.setLogin(email);
			usuario.setPassword(GenerateMD5.generate(senha));
			
			profile.setUser(usuario);
			ProfileDao profileDao = DAOFactory.criarProfile();
			
			profileDao.save(profile);;
			
			tentativa = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(tentativa == true){
			
		    RequestDispatcher rd = request.getRequestDispatcher("/publica/login_usuario.jsp");

			try {
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
