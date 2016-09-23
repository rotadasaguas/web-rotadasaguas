package br.com.dtech.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public Index() {
        super();
    }

	
	private void tratarRequisicao(HttpServletRequest request,
			HttpServletResponse response) {
		
		String ac = request.getParameter("acao");
		
		if(ac.equals("nova_conta")){
			chamarNovaConta(request, response);
		} 
		
	}
	

	private void chamarNovaConta(HttpServletRequest request,
			HttpServletResponse response) {
		
		RequestDispatcher rd = request.getRequestDispatcher("/publica/criar_conta.jsp");
		
		try {
           rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }		
		
	}


	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		tratarRequisicao(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		tratarRequisicao(request, response);
	}

}