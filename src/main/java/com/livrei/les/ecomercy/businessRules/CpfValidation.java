package com.livrei.les.ecomercy.businessRules;

import com.livrei.les.ecomercy.domain.Client;
import com.livrei.les.ecomercy.domain.EntityDomain;
import com.livrei.les.ecomercy.strategy.IStrategy;

public class CpfValidation implements IStrategy {
	@Override
	public String process(EntityDomain entity) {
		
		if(entity instanceof Client){
			Client client = (Client)entity;
			if (client.getCpf() == null || client.getCpf().length()!=11) {
				return "CPF Invalido";
			}
		}else {
			return "CPF não pode ser validado";
		}
		return null;
	}

}
