package com.luchienlin.springboot.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	
	// 要讓它訪問templates底下的
//	@RequestMapping({"/","/index.html"})
//	public String index() {
//		return "index";
//	}
	
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		
		return "Hello World";
	}
	
	// 查出一些數據，在頁面展示
	@RequestMapping("/success")
	public String success(Map<String, Object> map) {
		map.put("hello", "<h1>你好</h1>");
		map.put("users", Arrays.asList("張三","裡四"));
		//classpath:/templates/success.html
		return "success";
	}
}
