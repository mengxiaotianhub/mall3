package com.mengxiaotian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mengxiaotian.common.meta.Product;
import com.mengxiaotian.service.ContentService;
/**
 * 发布与编辑管理控制器
 * @author mengxiaotian
 */
@Controller
public class SubmitController {
	
	@Autowired
	private ContentService contentService;

	/**
	 * 商品发布
	 * @param product
	 * @param map
	 * @return
	 */
	@RequestMapping("/publicSubmit")
	public String pubSubmit(Product product,Model map){
		try{
		map.addAttribute("product", contentService.insertProduct(product));
		}catch(Exception e){
			e.printStackTrace();
			map.addAttribute("code",400);
			map.addAttribute("message","erorr");
			map.addAttribute("result",false);
		}
		map.addAttribute("code",200);
		map.addAttribute("message","comlpeted");
		map.addAttribute("result",true);
		return "publicSubmit";
	}
	
	/**
	 * 编辑提交
	 * @param product
	 * @param map
	 * @return
	 */
	@RequestMapping("/editSubmit")
	public String editSubmit(Product product,Model map){
		try{
			map.addAttribute("product",contentService.updateProduct(product));
			}catch(Exception e){
				e.printStackTrace();
				map.addAttribute("code",400);
				map.addAttribute("message","erorr");
				map.addAttribute("result",false);
			}
			map.addAttribute("code",200);
			map.addAttribute("message","comlpeted");
			map.addAttribute("result",true);
		return "editSubmit";
	}
	
	/**
	 * 编辑页面
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(@RequestParam("id") Integer id,Model map){
		try{
			map.addAttribute("product", contentService.selectProduct(id));
			}catch(Exception e){
				e.printStackTrace();
			}
		return "edit";
	}
	
	
}
