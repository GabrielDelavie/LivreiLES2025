package com.livrei.les.ecomercy.commands;

import com.livrei.les.ecomercy.application.Result;
import com.livrei.les.ecomercy.domain.EntityDomain;

public interface ICommand {
	public Result execute(EntityDomain entidade);
}
