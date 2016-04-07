package com.mengxiaotian.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mengxiaotian.common.meta.User;
import com.mengxiaotian.service.ContentService;
import com.mengxiaotian.service.TrxService;

@Controller
public class ShowController {
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private TrxService trxService;

	
	@RequestMapping("/")
	public String showIndex(Model map,HttpSession session){
		try {
			if(session.getAttribute("user")!=null){
		map.addAttribute("productList", contentService.getProductList(((User)session.getAttribute("user")).getId()));
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/show")
	public String showGoodsList(@Param("id")Integer id ,Model map,HttpSession session){
		try {
			map.addAttribute("productList", contentService.getProduct(id,((User)session.getAttribute("user")).getId()));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "show";
		
	}
	
	@RequestMapping("/account")
	public String showAccount(Model map,HttpSession session){
		map.addAttribute("productList", trxService.getBuyList(((User)session.getAttribute("user")).getId()));
		return "account";
	}

}
