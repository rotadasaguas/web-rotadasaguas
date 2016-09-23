<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../publica/resources.jspf"></jsp:include>
<title>Cadastro - Rota das Aguas</title>


</head>

<body>

		<script>
		function goBack() {
		    window.history.back();
		}
		</script>
		<div class="container">
			<div class="row center" style="margin-top:50px;">
		        <h3 style="font-size: 28px;">Cadastro de Conta</h3>
		    </div>
		    <div class="row">
		        <div class="container">
		           <form  action="ProfileController?acao=salvar" method="post">
			           <div class="row">
					        <div class="input-field col s12">
					          <input placeholder="Digite o Nome Completo" id="nome" name="nome" type="text" required>
					          <label for="nome">Nome</label>
					        </div>
					   </div>
						<div class="row">
					        <div class="input-field col s12">
					          <input placeholder="Digite o CPF só números" id="cpf" maxlength="11" size="11" name="cpf" type="number" required>
					          <label for="cpf">CPF</label>
					        </div>
					   </div>	
					   <div class="row">
					        <div class="input-field col s12">
					          <input placeholder="Digite o Celular só números" id="telefone" maxlength="11" size="11" name="telefone" type="number" required>
					          <label for="telefone">Celular</label>
					        </div>
					   </div>
					   <div class="row">
					        <div class="input-field col s12">
					          <input placeholder="Digite um e-mail valido" id="email" name="email" type="email" required>
					          <label for="email">E-Mail</label>
					        </div>
					   </div>
					   <div class="row">
					        <div class="input-field col s12">
					          <input placeholder="Digite sua senha" id=senha name="senha" type="password" required>
					          <label for="senha">Senha</label>
					        </div>
					   </div>				   
		           		<div class="row">
		                    <div class="col s12">
						      		<input type="checkbox" id="test5" checked="checked" disabled="disabled"/>
						      		<label for="test5">Eu li e aceito os <a href="#">termos de uso</a></label>
						      		<br/>
						      		<p><a href="#">Saiba mais</a> o motivo de pedirmos essas informações</p>
		                    </div>
		                </div>
		                <div class="row">
		                    <div class="col s12 m6 l6 login-button">
		                        <a class="btn waves-effect grey col s12"  type="submit"  onclick="goBack()">Voltar ao Login</a>
		                    </div>
		                    <div class="col s12 m6 l6 login-button">
		                    	<input type="submit" class="btn waves-effect light-blue darken-2  col s12" value="Concluir Cadastro"/>
		                    </div>
		                </div>
		            </form>
		        </div>
		    </div>
		</div>
</body>
</html>		