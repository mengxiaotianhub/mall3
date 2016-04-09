package com.mengxiaotian.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mengxiaotian.meta.Content;
import com.mengxiaotian.service.ContentService;

@Controller
public class SubmitController {
	
	@Autowired
	private ContentService contentService;

	@RequestMapping("/publicSubmit")
	public String pubSubmit(Content product,Model map){
		try{
		contentService.insertSelective(product);
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
	public String editSubmit(Content content,Model map){
		try{
			map.addAttribute("product",contentService.updateByPrimaryKey(content));
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
	public String edit(@Param("id") Integer contentId,Model map){
		map.addAttribute("product", contentService.selectByPrimaryKey(contentId));
		return "edit";
	}
	
	
}
