package com.livrei.les.ecomercy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livrei.les.ecomercy.application.Result;
import com.livrei.les.ecomercy.domain.Order;
import com.livrei.les.ecomercy.repositories.OrderRepository;

@Service
public class OrderService implements IService<Order> {
	@Autowired
	private OrderRepository repository;

	@Override
	public Result findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result insert(Order obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(Long id, Order obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
