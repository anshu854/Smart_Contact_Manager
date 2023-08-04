package com.smart.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.dao.UserRepo;
import com.smart.entities.Contact;
import com.smart.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepo repo;
	
	@ModelAttribute
	public void addCommonData(Model model,Principal principal) {
		String name = principal.getName();
		System.out.println("UserName : "+name);
		User user = repo.getUserByUserName(name);
		System.out.println("user : "+user);
		model.addAttribute("user",user);
	}
	
	@RequestMapping("/index")
	public String dashboard(Model model) {
		model.addAttribute("title","Dashboard - Smart Contact Manager");
		return "user/dashboard";
	}
	
	@GetMapping("/add-contact")
	public String openAddContact(Model model) {
		model.addAttribute("title","Add Contact - Smart Contact Manager");
		model.addAttribute("contact",new Contact());
		return "user/addContact";
	}
	
	@PostMapping("/process-contact")
	public String addContactHandler(@ModelAttribute Contact contact,Principal principal) {
		String name = principal.getName();
		User user = this.repo.getUserByUserName(name);
		contact.setUser(user);
		user.getContacts().add(contact);
		this.repo.save(user);
		System.out.println("Contact Details : "+contact);
		System.out.println("added");
		return "user/addContact";
	}
	
}
