package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Item;
import com.example.demo.domain.User;
import com.example.demo.form.UserForm;
import com.example.demo.repository.MercariRepository;

@Controller
@RequestMapping("/")
public class ViewController {

	@Autowired
	private MercariRepository mercariRepository;
	
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	@RequestMapping("/")
	public String view(Model model) {
		List<Item> itemList = mercariRepository.selectIdAndName();
		model.addAttribute("itemList", itemList);
		
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
