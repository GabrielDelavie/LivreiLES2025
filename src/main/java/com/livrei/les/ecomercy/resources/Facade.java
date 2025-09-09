package com.livrei.les.ecomercy.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.livrei.les.ecomercy.application.Result;
import com.livrei.les.ecomercy.businessRules.*;
import com.livrei.les.ecomercy.domain.*;
import com.livrei.les.ecomercy.domain.EntityDomain;
import com.livrei.les.ecomercy.services.*;
import com.livrei.les.ecomercy.strategy.IStrategy;

import jakarta.annotation.PostConstruct;

@Component
public class Facade implements IFacade{

	@Autowired
	private ClientService clientService;
	
	@Autowired 
	private OrderService orderService;
	
	
	private Map<String, IService<?>> services;
	
	private Map<String, Map<String, List<IStrategy>>> businessRules;
	
	private Result result;
	
	public Facade() {
        businessRules = new HashMap<>();
        result = new Result();
        services = new HashMap<>();
    }
	
	@PostConstruct
	public void init() {


		services.put(Order.class.getName(), orderService);
		services.put(Client.class.getName(), clientService);
		
		//instances of business rules
		CpfValidation vCpf = new CpfValidation();
		
		//creating the list of business Rules for CLIENT CREATE
		List<IStrategy> clientCreateBusinessRules = new ArrayList<IStrategy>();
		
		clientCreateBusinessRules.add(vCpf);
		
		//Mapping all lists of businessRules by operation for Client
		Map<String,List<IStrategy>> clientBusinessRulesMap = new HashMap<String, List<IStrategy>>();
		
		//adding operations to mapping
		clientBusinessRulesMap.put("CREATE", clientCreateBusinessRules);
		
		businessRules.put(Client.class.getName(), clientBusinessRulesMap);	
	}
	
	@Override
	public Result create(EntityDomain entity) {
		result = new Result();
		String className = entity.getClass().getName();
		String msg = executeRules(entity,"CREATE");
		if(msg==null||msg.length()==0){
			@SuppressWarnings("unchecked")
			IService<EntityDomain> service = (IService<EntityDomain>) services.get(className);
			result = service.insert(entity);
		
		}else {
			result.setMessage(msg.toString());
			result.setSuccess(false);
		}
		
		return result;
	}

	@Override
	public Result update(EntityDomain entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(EntityDomain entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result search(EntityDomain entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result view(EntityDomain entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String executeRules(EntityDomain entity, String operacao) {
		String className = entity.getClass().getName();
		StringBuilder message = new StringBuilder();
		Map<String,List<IStrategy>> operationRules= businessRules.get(className);
		if(operationRules != null) {
			List<IStrategy> rules = operationRules.get(operacao);
			if(rules != null) {
				for (IStrategy strategy : rules) {
					String msg = strategy.process(entity);
					
					if(msg!=null) {
						message.append(msg);
						message.append("\n");
					}
				}
			}
		}
		if(message.length()>0)
			return message.toString();
		else
			return null;
	}

}
