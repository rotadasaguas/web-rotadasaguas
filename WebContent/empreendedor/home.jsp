<%@page import="br.com.dtech.model.Profile"%>
<%@page import="br.com.dtech.model.Usuario"%>
<%@page import="br.com.dtech.model.Locais"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="../publica/resources.jspf"></jsp:include>
    <title>Home - Empreendedor</title>
</head>

<body>
    <jsp:include page="menu.jsp"></jsp:include>
    <div class="section no-pad-bot" id="index-banner">
        <div class="container">
        
        <% Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");	%>
        
       		 <%
					
			if(request.getParameter("acao").equals("login")){%>
				<script>
					var $toastContent = $('<span>Logado com sucesso!</span>');
					Materialize.toast($toastContent, 2000);
				</script>
			<%}%>
			
			
				<br>
	            <br>
	            <h1 class="header center blue-text">Rota das Águas</h1>
	            <div class="row center">
	                <h5 class="header col s12 light">O aplicativo do melhor circuito turistico de São Paulo - SP</h5>
	            </div>
	            <div class="row center">
	                <a href="LocaisController?acao=novo_cadastro" class="btn-large waves-effect waves-light blue">Começar Agora</a>
	            </div>
 
        </div>
    </div>

    <div class="container">
        <div class="section">

            <!--   Icon Section   -->
            <div class="row">
                <div class="col s12 m4">
                    <div class="icon-block">
                        <h2 class="center light-blue-text"><i class="material-icons">flash_on</i></h2>
                        <h5 class="center">Visibilidade</h5>

                        <p class="light">Aumente o número de clientes cadastrando seu negócio no Rota das Águas.</p>
                    </div>
                </div>

                <div class="col s12 m4">
                    <div class="icon-block">
                        <h2 class="center light-blue-text"><i class="material-icons">group</i></h2>
                        <h5 class="center">Facilidade</h5>

                        <p class="light">Nós proporcionamos a oportunidade para você divulgar quantos negócios quiser! De forma fácil e rápida!</p>
                    </div>
                </div>

                <div class="col s12 m4">
                    <div class="icon-block">
                        <h2 class="center light-blue-text"><i class="material-icons">settings</i></h2>
                        <h5 class="center">Gerenciamento</h5>

                        <p class="light">O controle da informação é seu! Atualize os dados de seu negócio sempre que tiver necessidade.</p>
                    </div>
                </div>
            </div>

        </div>
        <br>
        <br>
    </div>

</body>

</html>