package com.livrei.les.ecomercy.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.livrei.les.ecomercy.application.Result;
import com.livrei.les.ecomercy.domain.EntityDomain;
import com.livrei.les.ecomercy.resources.Facade;

@Component
public class CommandUpdate implements ICommand {
	@Autowired
	private Facade facade;
	
	public Result execute(EntityDomain entity) {
		return facade.update(entity);
	}

}
