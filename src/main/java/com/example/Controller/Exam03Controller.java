package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex03")
public class Exam03Controller {
	
	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "exam03";
	}
	
	@RequestMapping("/input")
	public String input(String num1,String num2,String num3){
		Integer intNum1 = Integer.parseInt(num1);
		Integer intNum2 = Integer.parseInt(num2);
		Integer intNum3 = Integer.parseInt(num3);
		
		Integer withoutTax = intNum1+intNum2+intNum3;
		Integer withTax = (int) ((intNum1+intNum2+intNum3)*1.1);
		application.setAttribute("withTax", withTax);
		application.setAttribute("withoutTax", withoutTax);

		return "exam03-result";
	}
	
}
