package com.livrei.les.ecomercy.resources;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.livrei.les.ecomercy.application.Result;
import com.livrei.les.ecomercy.commands.*;
import com.livrei.les.ecomercy.commands.ICommand;
import com.livrei.les.ecomercy.domain.EntityDomain;
import com.livrei.les.ecomercy.viewhelper.IViewHelper;
import com.livrei.les.ecomercy.viewhelper.VhClientRegister;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
	public class FrontController {

	    @Autowired
	    private CommandCreate commandCreate;
	    
	    @Autowired
	    private CommandUpdate commandUpdate;
	    
	    @Autowired
	    private CommandDelete commandDelete;
	    
	    @Autowired
	    private CommandSearch commandSearch;
	    
	    @Autowired
	    private CommandView commandView;

	    private Map<String, IViewHelper> viewHelpers = new HashMap<>();
	    private Map<String, ICommand> commands = new HashMap<>();
	    
	    public FrontController() {
	        viewHelpers.put("/user", new VhClientRegister());
	    }
	    
	    @PostConstruct
	    public void init(){

	        commands.put("CREATE", commandCreate);
	        commands.put("UPDATE", commandUpdate);
	        commands.put("DELETE", commandDelete);
	        commands.put("SEARCH", commandSearch);
	        commands.put("VIEW", commandView);
	    }


	    @PostMapping({"/user", "/product", "/order"})
	    public ModelAndView executar(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
	        String uri = request.getRequestURI(); 
	        String operation = request.getParameter("OPERATION"); 

	        IViewHelper vh = viewHelpers.get(uri);
	        EntityDomain entity= vh.getEntidade(request);

	        ICommand command = commands.get(operation);
	        Result resultado = command.execute(entity);

	        return vh.setView(resultado, request );
	    }
	}

