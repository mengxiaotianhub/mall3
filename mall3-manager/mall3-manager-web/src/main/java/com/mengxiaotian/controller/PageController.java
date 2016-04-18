package com.mengxiaotian.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 页面跳转管理控制器
 * @author mengxiaotian
 */
@Controller
public class PageController {

	
	/**
	 * 登陆页面跳转
	 * @return
	 */
	@RequestMapping("/login")
	public String logIn(){
		return "login";
	}
	/**
	 * 退出登陆页面跳转
	 * @return
	 */
	@RequestMapping("/logout")
	public String logOut(HttpSession session){
		session.invalidate();
		return "redirect:login";
	}
	/**
	 * 发布页面跳转
	 * @return
	 */
	@RequestMapping("/public")
	public String pul(){
		return "public";
	}
	
}
