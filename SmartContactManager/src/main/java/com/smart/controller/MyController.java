package com.smart.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.smart.dao.UserRepo;
import com.smart.entities.User;
import com.smart.helper.Message;

@Controller
public class MyController {
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Autowired
	private UserRepo repo;
	
	@RequestMapping("/")
	public String homeHandler(Model model) {
		model.addAttribute("title","Home - Smart Contact Manager");
		return "home";
	}
	
	@RequestMapping("/about")
	public String aboutHandler(Model model) {
		model.addAttribute("title","About - Smart Contact Manager");
		return "about";
	}
	
	@RequestMapping("/signup")
	public String Signup(Model model) {
		model.addAttribute("title","Register - Smart Contact Manager");
		model.addAttribute("user",new User());
		return "signup";
	}
	
	@PostMapping(value = "/do_register")
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result,@RequestParam(value = "agreement",defaultValue = "false") boolean agreement,Model model,HttpSession session) {
		try {
			if(!agreement) {
				System.out.println("You have not accept tems and condition");
				throw new Exception("You have not accept tems and condition");
			}
			if(result.hasErrors()) {
				System.out.println("Error : "+result.toString());
				model.addAttribute("user",user);
				return "signup";
			}
			user.setRole("ROLE_USER");
			user.setActive(true);
			user.setImage("default.png");
			user.setPassword(passEncoder.encode(user.getPassword()));
			System.out.println("agreement : "+agreement);
			System.out.println("User : "+user);
			User user2 = this.repo.save(user);
			model.addAttribute("user",new User());
			session.setAttribute("message",new Message("Successfully Registered!!","alert-success"));
			return "signup";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message",new Message("Something went wrong!!"+e.getMessage(),"alert-danger"));
			return "signup";
		}
	}
	
	@GetMapping("/login")
	public String loginHandler(Model model) {
		model.addAttribute("title","Login - Smart Contact Manager");
		return "login";
	}
}
