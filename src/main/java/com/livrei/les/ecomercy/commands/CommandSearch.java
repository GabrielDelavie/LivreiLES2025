package com.livrei.les.ecomercy.commands;

import com.livrei.les.ecomercy.application.Result;
import com.livrei.les.ecomercy.domain.EntityDomain;
import com.livrei.les.ecomercy.resources.Facade;

public class CommandSearch implements ICommand {

	public Result execute(EntityDomain entidade) {
		return new Facade().search(entidade);
	}

}
