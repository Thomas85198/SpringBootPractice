package com.luchienlin.springboot.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.luchienlin.springboot.dao.EmployeeDao;
import com.luchienlin.springboot.entities.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDao employeeDao;
	
	// 查詢所有員工返回列表頁面
	@GetMapping("/emps")
	public String list(Model model) {
		Collection<Employee> employee = employeeDao.getAll();
		
		// 放到請求域中
		model.addAttribute("emps", employee);
		
		// thymeleaf默認就會拚串
		// classpath:/templates/xxxx.html
		return "emp/list";
	}
	
}
