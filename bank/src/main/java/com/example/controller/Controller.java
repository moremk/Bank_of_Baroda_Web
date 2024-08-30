package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.entity.Bank;
import com.example.repository.Repository;



@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	public Repository repo;
		
	@GetMapping("/register")
	public String user()
	{
		return "register";
	}
	@GetMapping("/admin")
	public String admin()
	{
		return "admin";
	}
	@GetMapping("/bank")
	public String bank()
	{
		return "bank";
	}
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	@GetMapping("/baroda")
	public String baroda()
	{
		return "baroda";
	}

	

	 @PostMapping("/bank")
	    public String bank(@RequestParam("name") String name, @RequestParam("password") String password) {
	     
	        String Username = "admin";
	        String Password = "2000";
	        
	        if (name.equals(Username) && password.equals(Password)) {
	            return "baroda"; 
	        } else {
	            return "admin"; 
	        }
	    }		
	
	 
	  @PostMapping("/save")
	    public String register(@RequestParam("name") String name, @RequestParam("password") String password, Model model) {
		  
		  
		  if (repo.findByName(name) != null) {
	            model.addAttribute("message", "Username already exists");
	            return "register";
	        }
	        Bank user = new Bank();
	        user.setName(name);
	        user.setPassword(password);
	        repo.save(user);
	        return "bank";
	        
	    }
	  @PostMapping("/login")
	  public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model) {
	      Bank user = (Bank) repo.findByName(name);

	      if (user != null && user.getPassword().equals(password)) {
	        
	          return "bank"; 
	      }

	    
	      model.addAttribute("message", "Username Not Found");
	      return "login";
	  }

	 
	 
}
