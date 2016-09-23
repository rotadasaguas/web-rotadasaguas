<%@page import="br.com.dtech.model.Profile"%>
<%@page import="br.com.dtech.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
	
	HttpSession s = request.getSession();
	Profile perfil = (Profile) s.getAttribute("profile");
	Usuario usuario = (Usuario) s.getAttribute("usuario");	
	
	
	
	%>  

 	<header>
        <nav>
          <div class="nav-wrapper blue darken-1">
              <div class="container-fluid">
            <a href="#!" class="brand-logo">
            	<img class="logomarca" src="resource/images/logo.png"/>
            </a>

            <ul class="right hide-on-med-and-down">
              <li><a href="LocaisController?acao=listar">Meus Locais</a></li>
              <li><a href="collapsible.html">Minha Conta</a></li>
              <li><a href="UsuarioController?acao=sair">Logout</a></li>
              <li><a class="btn waves-effect waves-light  blue darken-4" href="buttons.html">Olá, ${sessionScope.profile.nome}</a></li>
            </ul>
            </div>
          </div>
        </nav>
	</header>