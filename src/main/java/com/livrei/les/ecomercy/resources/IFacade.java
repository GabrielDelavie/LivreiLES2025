package com.livrei.les.ecomercy.resources;

import com.livrei.les.ecomercy.application.Result;
import com.livrei.les.ecomercy.domain.EntityDomain;

public interface IFacade {
	public Result create(EntityDomain entity);
	public Result update(EntityDomain entity);
	public Result delete(EntityDomain entity);
	public Result search(EntityDomain entity);
	public Result view(EntityDomain entity);
}
