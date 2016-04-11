package com.mengxiaotian.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mengxiaotian.common.meta.Product;
import com.mengxiaotian.service.ContentService;

@Controller
public class SubmitController {
	
	@Autowired
	private ContentService contentService;

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
	
	@RequestMapping("/edit")
	public String edit(@Param("id") Integer id,Model map){
		try{
			map.addAttribute("product", contentService.selectProduct(id));
			}catch(Exception e){
				e.printStackTrace();
			}
		return "edit";
	}
	
	
}
