package com.example.demo.contoller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.User;
import com.example.demo.form.UserForm;

@Controller
@RequestMapping("/")
public class ViewController {

	
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	@RequestMapping("/")
	public String view(Model model) {
//		UserForm userForm = new UserForm();
//		model.addAttribute("userForm", userForm);
		//modelAttributeを書いているのでrequestMappingよりも先に呼ばれるので、空のフォームが送信される。
		return "sendSample";
	}
	
	@RequestMapping("/addUser")
	public String add(Model model, UserForm userForm) {
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		model.addAttribute("user", user);
		System.out.println(user);
		return "end";
	}
}
