<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../publica/resources.jspf"></jsp:include>
<title>Login - Rota das Aguas</title>


</head>

<body>
<div class="container">

			<%
			if(request.getParameter("acao") == null){
				System.out.println("Sem parametros");
			}
			else{	
				if(request.getParameter("acao").equals("sair")){%>
					<script>
						var $toastContent = $('<span>Você saiu com sucesso!</span>');
						Materialize.toast($toastContent, 2000);
					</script>
				<%}%>
				
				<%
						
				if(request.getParameter("acao").equals("salvar")){%>
					<script>
						var $toastContent = $('<span>Conta criada com sucesso!</span>');
						Materialize.toast($toastContent, 4000);
					</script>
				<%}%>
				
				<%
						
				if(request.getParameter("acao").equals("error")){%>
					<script>
						var $toastContent = $('<span>E-mail ou senha invalida!</span>');
						Materialize.toast($toastContent, 4000);
					</script>
				<%}
			}
			%>
			
			
		
		    <div class="row center" style="margin-top:50px;">
		        <div class="logo">
		            <img class="logo responsive-img" src="resource/images/icone-android-screen.svg" width="200"/>
		        </div>
		    </div>
		    <div class="row">
		        <div class="container">
			        	<form method="post" action="UsuarioController?acao=login" style="margin-bottom:20px;">
	                        <div class="input-field col s12">
	                            <input type="email" name='user' 
	                                   id="user" placeholder="Digite seu E-mail" required>
	                        </div>
	                        <div class="input-field col s12">
	                            <input type="password" name='password'
	                                id="password" placeholder="Digite sua Senha" required>
	                        </div>                  
	                        <div class="input-field col s12">
	                        	<div class="center">
	                            	<button type="submit" class="btn waves-effect light-blue darken-2 login-button">Entrar no Sistema</button>                          
	                        	</div>
	                        </div>
	                        <div style="clear:both;"></div>
	                    </form>
	                    
		                <div class="row" style="margin-top:20px;">
		                    <div class="col s12 m6 l6 login-button">                 
	                            <a class="btn waves-effect grey col s12" href="Index?acao=nova_conta">Criar minha conta</a> 
		                    </div>
		                     <div class="col s12 m6 l6 login-button">                 
	                            <button class="btn waves-effect grey col s12">Esqueci minha Senha</button> 
		                    </div>
		                </div>
		        </div>
		    </div>
		
		</div>
</body>
</html>