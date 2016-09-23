package br.com.dtech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dtech.dao.LocaisDao;
import br.com.dtech.dao.TagDao;
import br.com.dtech.dao.UsuarioDao;
import br.com.dtech.dao.utils.DAOFactory;
import br.com.dtech.model.Locais;
import br.com.dtech.model.Profile;
import br.com.dtech.model.Tag;
import br.com.dtech.model.Usuario;

@WebServlet("/LocaisController")
public class LocaisController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public LocaisController() {
		super();
	}

	private void tratarRequisicao(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		Usuario verificador = (Usuario)session.getAttribute("usuario");
		
		System.out.println(verificador);
		
		if(verificador != null){
			
			String ac = request.getParameter("acao");

			if (ac.equals("salvar")) {
				salvar(request, response);
			}else if (ac.equals("listar")) {
				listar(request, response);
			}else if (ac.equals("novo_cadastro")) {
				novo(request, response);
			}else if (ac.equals("cadastrado")) {
				sucesso(request, response);
			}else if (ac.equals("error")) {
				error(request, response);
			}
		}
		else{
			RequestDispatcher rd = request
					.getRequestDispatcher("/publica/login_usuario.jsp?acao=login");

			try {
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}

	}
	
	public void salvar(HttpServletRequest request, HttpServletResponse response){
		
		
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String tipo = request.getParameter("tipo");
		String faixaMenor = request.getParameter("faixaMenor");
		String faixaMaior = request.getParameter("faixaMaior");
		String cidade = request.getParameter("cidade");
		int numero =  Integer.parseInt( request.getParameter("numero"));
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String endereco = request.getParameter("endereco");
		String infoExtra = request.getParameter("infoExtra");
		
		String tagDescricao = request.getParameter("tagDescricao");
		String tagDescricao2 = request.getParameter("tagDescricao2");
		String tagDescricao3 = request.getParameter("tagDescricao3");
		
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		Profile profile = (Profile) session.getAttribute("profile");
		
		Locais negocio = new Locais();
		Tag tag = new Tag();
		Tag tag2 = new Tag();
		Tag tag3 = new Tag();
		
		tag.setDescricao(tagDescricao);
		tag2.setDescricao(tagDescricao2);
		tag3.setDescricao(tagDescricao3);
		
		System.out.print(tag3.getDescricao());
		
		negocio.setNome(nome);
		negocio.setDescricao(descricao);
		negocio.setTipo(tipo);
		negocio.setFaixaMenor(faixaMenor);
		negocio.setFaixaMaior(faixaMaior);
		negocio.setCidade(cidade);
		negocio.setNumero(numero);
		negocio.setBairro(bairro);
		negocio.setCEP(cep);
		negocio.setEndereco(endereco);
		negocio.setInfoExtra(infoExtra);
		
		negocio.setUser(usuario);
		tag.setLocais(negocio);
		tag2.setLocais(negocio);
		tag3.setLocais(negocio);
		
		TagDao tagDao = DAOFactory.criarTag();
		TagDao tagDao2 = DAOFactory.criarTag();
		TagDao tagDao3 = DAOFactory.criarTag();
		
		tagDao.save(tag);
		tagDao.save(tag2);
		tagDao.save(tag3);
		
		LocaisDao locaisDao = DAOFactory.criarLocal();
		locaisDao.save(negocio);
		
		

		try {
			sucesso(request, response);
		} catch (Exception e) {
			error(request, response);
		}
		
	}
	
	public void listar(HttpServletRequest request, HttpServletResponse response){
		RequestDispatcher rd = request
				.getRequestDispatcher("/empreendedor/meus_locais.jsp?acao=listar");

		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void sucesso(HttpServletRequest request, HttpServletResponse response){
		RequestDispatcher rd = request
				.getRequestDispatcher("/empreendedor/meus_locais.jsp?acao=cadastrado");

		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void error(HttpServletRequest request, HttpServletResponse response){
		RequestDispatcher rd = request
				.getRequestDispatcher("/empreendedor/meus_locais.jsp?acao=error");

		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void novo(HttpServletRequest request, HttpServletResponse response){
		RequestDispatcher rd = request
				.getRequestDispatcher("/empreendedor/cadastro_local.jsp");

		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editar(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	public void excluir(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	public void verLocais(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession(true);
		LocaisDao locaisDao = DAOFactory.criarLocal();
		
		List<Locais> lista = locaisDao.all();
		System.out.println(lista);
		session.setAttribute("lista", lista);
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
