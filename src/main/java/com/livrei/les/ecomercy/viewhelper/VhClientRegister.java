package com.livrei.les.ecomercy.viewhelper;

import java.io.IOException;


import com.livrei.les.ecomercy.application.Result;
import com.livrei.les.ecomercy.domain.EntityDomain;
import com.livrei.les.ecomercy.domain.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VhClientRegister implements IViewHelper{
	@Override
	public EntityDomain getEntidade(HttpServletRequest request) {
		User user = new User();
		
		String nome = request.getParameter("txtNome");
		String cpf = request.getParameter("txtCpf");
		String matricula = request.getParameter("txtMatricula");
		String regional = request.getParameter("txtRegional");
		String setor = request.getParameter("txtSetor");
		String cargo = request.getParameter("txtCargo");
		String[] perfis =  request.getParameterValues("txtPerfil");
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("txtSenha");
		String confirmacaoSenha = request.getParameter("txtConfirmacaoSenha");
		
		
		return user;
	}

	@Override
	public void setView(Result result, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		if(result != null) {
			if(result.getMessage()==null) {
				
				result.setMessage("Funcionario cadastrado com sucesso!");
				request.setAttribute("Mensagem", result.getMessage());
				request.getRequestDispatcher("cadastro-funcionario.jsp").forward(request, response);
			}else {
				request.setAttribute("Mensagem", result.getMessage());
				request.getRequestDispatcher("cadastro-funcionario.jsp").forward(request, response);
			}	
		}
		
	}
}
