package com.livrei.les.ecomercy.viewhelper;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import com.livrei.les.ecomercy.application.Result;
import com.livrei.les.ecomercy.domain.EntityDomain;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IViewHelper {

	public EntityDomain getEntidade(HttpServletRequest request);
	
	public void setView(Result resultado,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

}
