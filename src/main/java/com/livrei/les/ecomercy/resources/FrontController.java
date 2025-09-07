package com.livrei.les.ecomercy.resources;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livrei.les.ecomercy.application.Result;
import com.livrei.les.ecomercy.commands.*;
import com.livrei.les.ecomercy.commands.ICommand;
import com.livrei.les.ecomercy.domain.EntityDomain;
import com.livrei.les.ecomercy.viewhelper.IViewHelper;
import com.livrei.les.ecomercy.viewhelper.VhClientRegister;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
	public class FrontController {

	    private Map<String, IViewHelper> viewHelpers = new HashMap<>();
	    private Map<String, ICommand> commands = new HashMap<>();

	    public FrontController() {
	        viewHelpers.put("/usuario", new VhClientRegister());

	        commands.put("CREATE", new CommandCreate());
	        commands.put("UPDATE", new CommandUpdate());
	        commands.put("DELETE", new CommandDelete());
	        commands.put("SEARCH", new CommandSearch());
	        commands.put("VIEW", new CommandView());
	    }

	    @PostMapping({"/usuario", "/produto", "/pedido"})
	    public void executar(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
	        String uri = request.getRequestURI(); 
	        String operacao = request.getParameter("OPERACAO"); 

	        IViewHelper vh = viewHelpers.get(uri);
	        EntityDomain entity= vh.getEntidade(request);

	        ICommand command = commands.get(operacao);
	        Result resultado = command.execute(entity);

	        vh.setView(resultado, request, response );
	    }
	}

