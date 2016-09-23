<%@page import="br.com.dtech.model.Profile"%>
<%@page import="br.com.dtech.model.Usuario"%>
<%@page import="br.com.dtech.model.Locais"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="../publica/resources.jspf"></jsp:include>
    <title>Meus Locais - Empreendedor</title>
</head>

<body>
    <jsp:include page="menu.jsp"></jsp:include>
    	<% Usuario usuario = (Usuario)request.getSession(true).getAttribute("usuario");	%>
    	
    		<%
					
			if(request.getParameter("acao").equals("login")){%>
				<script>
					var $toastContent = $('<span>Logado com sucesso!</span>');
					Materialize.toast($toastContent, 2000);
				</script>
			<%}%>
			
    
     		<%
					
			if(request.getParameter("acao").equals("cadastrado")){%>
				<script>
					var $toastContent = $('<span>Cadastrado com sucesso!</span>');
					Materialize.toast($toastContent, 2000);
				</script>
			<%}%>
			
		<div class="container-fluid">
        	<div class="row" style="margin-top:35px;">
        		<div class="center">
        			<a href="LocaisController?acao=novo_cadastro" class="btn-large waves-effect waves-light green">Cadastrar Negocio</a>
        		</div>
        	</div>
			
		<%
			int verificador = 0;
				if(usuario.getLocais().size() != 0){%>
				<div class="row" style="margin-top:40px;">
				<%
					verificador = 1;
					for (Locais locais : usuario.getLocais()) { %>
						
			        		<div class="col s3">
					        	<div class="card">
								    <div class="card-image waves-effect waves-block waves-light">
								      <img class="activator" src="https://media-cdn.tripadvisor.com/media/photo-s/06/d6/2a/7a/pastelaria-simples.jpg">
								    </div>
								    <div class="card-content">
								      <span class="card-title activator grey-text text-darken-4" style="font-size: 16px;text-transform: uppercase;line-height: 30px;"><%= locais.getNome() %><i class="material-icons right">more_vert</i></span>
								    </div>
								    <div class="card-reveal">
								      <span class="card-title grey-text text-darken-4"><%= locais.getNome() %><i class="material-icons right">close</i></span>
								      <p><%= locais.getDescricao() %></p>
								      <p style="font-size:12px;"><strong>Endereço: </strong><%= locais.getEndereco() %>,  <strong>Nº: </strong><%= locais.getCidade() %><br>
								      	 <strong>Bairro: </strong><%= locais.getBairro() %> <strong>Cidade: </strong><%= locais.getCidade() %><br>
								      	 <strong>CEP: </strong><%= locais.getCEP() %><br>
								      </p>
								      	<p><a class="waves-effect waves-light btn z-depth-1 col s2 blue-grey lighten-2"><i class="material-icons left">mode_edit</i>Editar</a></p>
								    	<p><a class="btn right z-depth-0 col s9 transparent green-text text-darken-2"><i class="material-icons left">done</i>Aprovado</a></p>
								    	 <div class="clear"></div>
								    </div>
		
							  	</div>
						  	</div>
		        		
					<% } // FIM FOR %>
				</div>
				<% }else{ //FIM IF %>
				
        	<div class="row" style="margin-top:35px;">
        		<h2 class="center" style="font-size:18px;">Você ainda não possui negócios adicionados!</h2>
        	</div>
        </div>
        
        <% }//fim else %>

</body>

</html>