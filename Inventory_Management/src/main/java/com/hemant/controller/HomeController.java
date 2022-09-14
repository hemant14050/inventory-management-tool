package com.hemant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
	
	@RequestMapping("/")
	public String home() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping(path="/checkLogin",method=RequestMethod.POST)
	public String checkLogin(HttpServletRequest request) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		if(email.equals("admin@gmail.com") && password.equals("admin")) {
			return "dashboard";
		}
		return "login";
	}
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
	@RequestMapping("/error")
	public String error() {
		return "error";
	}
	@RequestMapping("/error1")
	public String error1() {
		return "error1";
	}
	@RequestMapping("/errormsg")
	public String errormsg(@RequestParam String msg, Model m) {
		m.addAttribute("msg", msg);
		return "errormsg";
	}
	@RequestMapping("/errormsg1")
	public String errormsg1(@RequestParam String msg, Model m) {
		m.addAttribute("msg", msg);
		return "errormsg1";
	}
}
