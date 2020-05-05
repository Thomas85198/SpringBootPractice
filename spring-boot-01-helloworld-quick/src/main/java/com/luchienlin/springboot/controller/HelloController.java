package com.luchienlin.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 這個類的所有方法返回的數據寫給瀏覽器(如果對象是JSON數據)
//@ResponseBody
//@Controller
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello world quick!";
	}
}
