package com.mengxiaotian.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mengxiaotian.common.meta.User;
import com.mengxiaotian.service.ContentService;
import com.mengxiaotian.service.TrxService;

/**
 * 页面展示管理控制器
 * @author mengxiaotian
 */
@Controller
public class ShowController {

	@Autowired
	private ContentService contentService;

	@Autowired
	private TrxService trxService;

	/**
	 * 首页展示
	 * @param map
	 * @param session
	 * @return
	 */
	@RequestMapping("/")
	public String showIndex(Model map, HttpSession session) {
		//如果用户登陆过，返回带购买信息的商品列表，否则只返回商品列表		
		try {
			if (session.getAttribute("user") != null) {
				map.addAttribute("productList",
						contentService.getProductList(((User) session.getAttribute("user")).getId()));
			} else {
				map.addAttribute("productList", contentService.getAllProductList());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}

	/**
	 * 商品详情页页展示
	 * @para id
	 * @param map
	 * @param session
	 * @return
	 */
	@RequestMapping("/show")
	public String showGoodsList( Integer id, Model map, HttpSession session) {
		try {
			if (session.getAttribute("user") != null) {
				map.addAttribute("product",
						contentService.getProduct(id, ((User) session.getAttribute("user")).getId()));
			} else {
				map.addAttribute("product", contentService.selectProduct(id));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "show";

	}
	/**
	 * 账务详情页页展示
	 * @param map
	 * @param session
	 * @return
	 */
	@RequestMapping("/account")
	public String showAccount(Model map, HttpSession session) {
		map.addAttribute("buyList", trxService.getBuyList(((User) session.getAttribute("user")).getId()));
		return "account";
	}

}
