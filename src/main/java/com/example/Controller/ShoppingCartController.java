package com.example.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;

@Controller
@RequestMapping("/shopping_cart")
public class ShoppingCartController {
	
	@Autowired
	private ServletContext application;
	
	@Autowired
	private HttpSession session;

	@RequestMapping("")
	public String index(Model model) {
		
		List<Item>itemList = new LinkedList<>();
		Item item1 = new Item();
		item1.setName("手帳ノート");
		item1.setPrice(1000);
		
		Item item2 = new Item();
		item2.setName("文房具セット");
		item2.setPrice(1500);
		
		Item item3 = new Item();
		item3.setName("ファイル");
		item3.setPrice(2000);
		
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		
		application.setAttribute("itemList", itemList);
		
		if(session.getAttribute("cartList")!=null) {
			List<Item>cartList = (List<Item>) session.getAttribute("cartList");
			Integer price = 0;
			for(Item item : cartList) {
				price = price + item.getPrice();
			}
			model.addAttribute("price",price);
		}
		
		return "item-and-cart";
	}
	
	@RequestMapping("/in_cart")
	public String inCart(Integer id,Model model) {
		List<Item>itemList = new LinkedList<>();
		itemList = (List<Item>) application.getAttribute("itemList");
		Item cartItem = itemList.get(id);

		if(session.getAttribute("cartList")==null) {
			List<Item>cartList = new LinkedList<>();
			cartList.add(cartItem);
			session.setAttribute("cartList", cartList);
		}else {
			List<Item>cartList = (List<Item>) session.getAttribute("cartList");
			cartList.add(cartItem);
			session.setAttribute("cartList", cartList);
		}
		
		return index(model);
		
	}
	
	@RequestMapping("/cart_delete")
	public String cartDelete(int id,Model model) {
		List<Item>cartList = new LinkedList<>();
		cartList = 	(List<Item>) session.getAttribute("cartList");
		cartList.remove(id);
		System.out.println(cartList);
		session.setAttribute("cartList", cartList);
		return index(model);
	}
	
	@RequestMapping("delete_all")
	public String deleteAll(Model model) {
		List<Item>cartList = new LinkedList<>();
		cartList = 	(List<Item>) session.getAttribute("cartList");
		cartList.clear();
		System.out.println(cartList);
		session.setAttribute("cartList", cartList);
		return index(model);
	}
	
}
