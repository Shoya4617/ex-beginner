package com.example.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex02")
public class Exam02Controller {
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
	public String index() {
		return "exam02";
	}
	
	@RequestMapping("/add")
	public String add(Model model,String num1,String num2) {
		Integer num3 = Integer.parseInt(num1);
		Integer num4 = Integer.parseInt(num2);
		Integer num5 = num3+num4;
		
		session.setAttribute("num3",num3);
		session.setAttribute("num4",num4);
		session.setAttribute("num5",num5);
		
		return "exam02_result";
	}
	
	@RequestMapping("/result")
	public String toResult() {
		return "exam02_result2";
	}

}
