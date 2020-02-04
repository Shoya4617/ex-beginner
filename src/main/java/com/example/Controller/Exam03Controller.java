package com.example.Controller;

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
	
	@RequestMapping("/result")
	public String result(String num1,String num2,String num3) {
		Integer num4 = Integer.parseInt(num1);
		Integer num5 = Integer.parseInt(num2);
		Integer num6 = Integer.parseInt(num3);
		
		Integer withoutTax = num4+num5+num6;
		Integer withTax = (int) ((num4+num5+num6)*1.1);
		System.out.println(withoutTax);
		System.out.println(withTax);
		
		application.setAttribute("withoutTax", withoutTax);
		application.setAttribute("withTax", withTax);
		return "exam03-result";
	}


}
