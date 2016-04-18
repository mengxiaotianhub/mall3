package com.mengxiaotian.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mengxiaotian.common.meta.User;
import com.mengxiaotian.service.ContentService;
import com.mengxiaotian.service.PersonService;
import com.mengxiaotian.service.TrxService;

/**
 * API管理控制器
 * @author mengxiaotian
 */
@Controller
@RequestMapping(value = "/api")
public class ApiController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private TrxService trxService;

	/**
	 * 登陆，根据登陆状态返回json数据
	 * @param userName
	 * @param password
	 * @param map
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String userLogin(@RequestParam("userName") String userName, @RequestParam("password") String password, Model map,
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
	
	/**
	 * 根据商品id删除商品并返回json数据
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public String productDelete(@RequestParam("id") Integer id, Model map) {
		contentService.deleteByPrimaryKey(id);
		map.addAttribute("code",200);
		map.addAttribute("message","comlpeted");
		map.addAttribute("result",true);
				return "json";
	}
	/**
	 * 根据商品id购买商品并返回json数据
	 * @param id
	 * @param map
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/buy")
	public String productBuy(@RequestParam("id") Integer id, Model map,HttpSession session) {
		trxService.buy(id,((User)session.getAttribute("user")).getId());
		map.addAttribute("code",200);
		map.addAttribute("message","comlpeted");
		map.addAttribute("result",true);
				return "json";
	}

}
