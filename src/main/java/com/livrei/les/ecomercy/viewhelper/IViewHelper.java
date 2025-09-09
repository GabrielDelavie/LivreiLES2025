package com.livrei.les.ecomercy.viewhelper;

import org.springframework.web.servlet.ModelAndView;

import com.livrei.les.ecomercy.application.Result;
import com.livrei.les.ecomercy.domain.EntityDomain;

import jakarta.servlet.http.HttpServletRequest;
public interface IViewHelper {

	EntityDomain getEntidade(HttpServletRequest request);
	
	ModelAndView setView(Result resultado,HttpServletRequest request);


}
