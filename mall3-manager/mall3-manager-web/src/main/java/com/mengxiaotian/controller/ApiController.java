package com.mengxiaotian.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mengxiaotian.common.meta.User;
import com.mengxiaotian.service.ContentService;
import com.mengxiaotian.service.PersonService;
import com.mengxiaotian.service.TrxService;

@Controller
@RequestMapping(value = "/api")
public class ApiController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private TrxService trxService;

	//用户登陆验证，失败返回登陆页面并显示提示信息
	@RequestMapping(value = "/login")
	public String userLogin(@Param("userName") String userName, @Param("password") String password, Model map,
			HttpSession session) {
		if (personService.login(userName, password)) {
			session.setAttribute("user", personService.getUser(userName));
			map.addAttribute("code",200);
			map.addAttribute("message","comlpeted");
			map.addAttribute("result",true);
			return "json";
		} else {
			map.addAttribute("code",201);
			map.addAttribute("message", "UserName or Password Error,please try again.");
			map.addAttribute("result",false);
			return "json";
		}
	}
	
	@RequestMapping(value = "/delete")
	public String productDelete(@Param("id") Integer contentId, Model map) {
		contentService.deleteByPrimaryKey(contentId);
		map.addAttribute("code",200);
		map.addAttribute("message","comlpeted");
		map.addAttribute("result",true);
				return "json";
	}
	
	@RequestMapping(value = "/buy")
	public String productBuy(@Param("id") Integer contentId, Model map,HttpSession session) {
		trxService.buy(contentId,((User)session.getAttribute("user")).getId());
		map.addAttribute("code",200);
		map.addAttribute("message","comlpeted");
		map.addAttribute("result",true);
				return "json";
	}

}
