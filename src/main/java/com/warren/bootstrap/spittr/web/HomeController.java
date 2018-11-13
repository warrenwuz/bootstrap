package com.warren.bootstrap.spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/11 15:34
 */
@Controller
public class HomeController {
	@RequestMapping(value = {"/","/homePage"},method = RequestMethod.GET )
	public String home(){
		return "home";
	}
}
