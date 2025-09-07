package com.livrei.les.ecomercy.commands;

import com.livrei.les.ecomercy.application.Result;
import com.livrei.les.ecomercy.domain.EntityDomain;
import com.livrei.les.ecomercy.resources.Facade;

public class CommandView implements ICommand {

	public Result execute(EntityDomain entity) {
		return new Facade().view(entity);
	}

}
