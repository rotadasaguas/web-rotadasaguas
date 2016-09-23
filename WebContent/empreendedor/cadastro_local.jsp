<%@page import="br.com.dtech.model.Profile"%>
<%@page import="br.com.dtech.model.Usuario"%>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="../publica/resources.jspf"></jsp:include>
    <title>Novo Local - Empreendedor</title>
</head>

<body>
    <jsp:include page="menu.jsp"></jsp:include>
        <div class="container">
        	<div class="row" style="margin-top:35px;">        	
        	
        		<h2 class="center" style="font-size:24px;">Cadastro do Negócio</h2>
        	</div>
        	<div class="row" style="margin-top:35px;">
        		<form  action="LocaisController?acao=salvar" method="post">
			           <div class="row">
							<div class="center col s3">
						   		<img src="resource/images/Loja.png">
						   		<br>
						   		<input name="tipo" value="Bar/Restaurante" type="radio" id="bar" />
	     		 		   		<label for="bar">Bares & Restaurantes</label>
	     		 		   </div>
	     		 		   <div class="center col s3">
						   		<img src="resource/images/Acomodação.png">
						   		<br>
						   		<input name="tipo" value="Acomodação" type="radio" id="acomodacao" />
	     		 		   		<label for="acomodacao">Acomodação</label>
	     		 		   </div>
	     		 		   <div class="center col s3">
						   		<img src="resource/images/Loja.png">
						   		<br>
						   		<input name="tipo" value="Loja" type="radio" id="loja" />
	     		 		   		<label for="loja">Loja / Comércio</label>
	     		 		   </div>
	     		 		   <div class="center col s3">
						   		<img src="resource/images/Turismo.png">
						   		<br>
						   		<input name="tipo" value="Turismo" type="radio" id="turismo" />
	     		 		   		<label for="turismo">Turismo</label>
	     		 		   </div>
	     		 		</div>
	     		 		<div class="row" style="margin-top:40px;">
	     		 			<div class="input-field col s4">
					          <input placeholder="Digite o Nome do Local" id="nome" name="nome" type="text" required>
					          <label for="nome">Nome</label>
					        </div>
					        <div class="input-field col s8">
					          <input placeholder="Digite um pouco sobre o local" id="descricao" name="descricao" type="text" required>
					          <label for="descricao">Descrição</label>
					        </div>
	     		 		</div>
	     		 		<div class="row">
	     		 			<div class="input-field col s3">
					          <input placeholder="Faixa de preço menor" id="faixaMenor" name="faixaMenor" type="text" required>
					          <label for="faixaMenor">Faixa de Preço Baixa</label>
					        </div>
	     		 			<div class="input-field col s3">
					          <input placeholder="Faixa de preço maior" id="faixaMaior" name="faixaMaior" type="text" required>
					          <label for="faixaMaior">Faixa de Preço Alta</label>
					        </div>
	     		 			<div class="input-field col s6">
					          <input placeholder="Digite seu diferencial" id="infoExtra" name="infoExtra" type="text" required>
					          <label for="infoExtra">Diferencial do Local</label>
					        </div>
	     		 		</div>
	     		 		
	     		 		<div class="row">
	     		 			<span style="color:#902424; padding:10px;">Atenção digite 3 palavras chaves que apontem para seu negócio Exemplo: Comida Italiana, Futebol, Piscina, Downhill..</span><br>
	     		 			<div class="input-field col s4">
					          <input placeholder="Digite uma palavra" id="tagDescricao" name="tagDescricao" type="text" required>
					          <label for="tagDescricao">Tag 1</label>
					        </div>
	     		 			<div class="input-field col s4">
					          <input placeholder="Digite uma palavra" id="tagDescricao2" name="tagDescricao2" type="text" required>
					          <label for="tagDescricao2">Tag 2</label>
					        </div>
	     		 			<div class="input-field col s4">
					          <input placeholder="Digite uma palavra" id="tagDescricao3" name="tagDescricao3" type="text" required>
					          <label for="tagDescricao3">Tag 3</label>
					        </div>
	     		 		</div>
	     		 		 
	     		 		<div class="row" style="margin-top:40px;">
	     		 			<div class="input-field col s3">
					          <input placeholder="Cidade do Circuito" id="cidade" name="cidade" type="text" required>
					          <label for="cidade">Cidade</label>
					        </div>
	     		 			<div class="input-field col s1">
					          <input value="SP" id="estado" name="estado" type="text" disabled="disabled">
					          <label for="estado">Estado</label>
					        </div>
	     		 			<div class="input-field col s5">
					          <input placeholder="Bairro do Local" id="bairro" name="bairro" type="text" required>
					          <label for="bairro">Bairro</label>
					        </div>
					        <div class="input-field col s3">
					          <input placeholder="CEP" id="cep" name="cep" type="text" required>
					          <label for="cep">CEP</label>
					        </div>
	     		 		</div>
	     		 		<div class="row">
	     		 			<div class="input-field col s10">
					          <input placeholder="Endereço" id="endereco" name="endereco" type="text" required>
					          <label for="endereco">Endereço</label>
					        </div>
	     		 			<div class="input-field col s2">
					          <input placeholder="Número" id="numero" name="numero" type="text" required>
					          <label for="numero">Número</label>
					        </div>
	     		 		</div>
	     		 		<div class="row">
		                    <div class="col s12 m6 l4 login-button">
		                        <a class="btn waves-effect grey col s12"  type="submit"  href="LocaisController?acao=listar"> Voltar para Meus Locais</a>
		                    </div>
		                    <div class="col s12 m6 l4 login-button right">
		                    	<input type="submit" class="btn waves-effect light-blue darken-2  col s12" value="Concluir Cadastro"/>
		                    </div>
		                </div>
		            </form>
        	</div>
        </div>

</body>

</html>