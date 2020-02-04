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
	
	@RequestMapping("/input")
	public String input(String num1,String num2,String num3){
		Integer num4 = Integer.parseInt(num1);
		Integer num5 = Integer.parseInt(num2);
		Integer num6 = Integer.parseInt(num3);
		application.setAttribute("num4", num4);
		application.setAttribute("num5", num5);
		application.setAttribute("num6", num6);

		return "exam03-result";
	}

}
