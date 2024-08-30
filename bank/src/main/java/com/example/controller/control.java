package com.example.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.entity.Baroda;
import com.example.entity.Deposite;
import com.example.repository.BRepository;
import com.example.repository.DRepository;


@org.springframework.stereotype.Controller
public class control {
	
	@Autowired
	private BRepository repo;
	
	@Autowired
	private DRepository repoo;
	

	
	@GetMapping("/createAccount")
	public String account()
	{
		return"createAccount";
	}
	
	@GetMapping("/deposite")
	public String deposite()
	{
		return"deposite";
	}
	@GetMapping("/withdraw")
	public String withdraw()
	{
		return"withdraw";
	}
	
	
	@GetMapping("/Balance")
	public String showForm(Model m) {
	    m.addAttribute("deposite", new Deposite()); 
	    return "Balance"; 
	}

	
	@PostMapping("/account")
	public String account(@ModelAttribute Baroda account, Model model) {
		Long randomNumber = ThreadLocalRandom.current().nextLong(100000000000L, 1000000000000L);
	    account.setAccount(randomNumber);
	    repo.save(account);
	    model.addAttribute("randomNumber", randomNumber);
	    return "redirect:/createAccount";
	}

	
	@PostMapping("/deposite")
	public String deposite(@ModelAttribute Deposite deposite) {
	    double accountNumber = deposite.getAccount();
	    double depositAmount = deposite.getAmount();

	    
	    List<Deposite> accounts = repoo.findByAccount(accountNumber);

	    if (!accounts.isEmpty()) {
	       
	        if (accounts.size() > 1) {
	            throw new RuntimeException("Multiple accounts found with the same number. Data integrity issue.");
	        }

	       
	        Deposite existingAccount = accounts.get(0);
	        double currentBalance = existingAccount.getBalance();
	        existingAccount.setBalance(currentBalance + depositAmount);
	      
	        repoo.save(existingAccount);
	        System.out.println("Updated Balance for Account Number " + existingAccount.getAccount() + ": " + existingAccount.getBalance());
	    } else {
	     
	        deposite.setBalance(depositAmount); 
	        repoo.save(deposite);
	        System.out.println("Inserted New Deposit for Account Number " + deposite.getAccount() + ": " + deposite.getBalance());
	    }

	    return "redirect:/deposite";
	}

	@PostMapping("/withdraw")
	public String withdraw(@ModelAttribute Deposite deposite) {
		 double accountNumber = deposite.getAccount();
		    double  withdrawalAmount= deposite.getAmount();

	    
	    List<Deposite> accounts = repoo.findByAccount(accountNumber);

	    if (accounts != null && !accounts.isEmpty()) {
	      
	        Deposite existingAccount =accounts.get(0);
	        double currentBalance = existingAccount.getBalance();

	        if (currentBalance >= withdrawalAmount) {
	            existingAccount.setBalance(currentBalance - withdrawalAmount);
	            repoo.save(existingAccount);
	            System.out.println("Updated Balance for Account Number " + existingAccount.getAccount() + ": " + existingAccount.getBalance());
	        } else {
	           
	            System.out.println("Insufficient funds for Account Number " + existingAccount.getAccount());
	            
	        }
	    } else {
	   
	        System.out.println("Account Number " + accountNumber + " not found.");
	        
	    }

	    return "redirect:/withdraw";
	}

	@PostMapping("/Balance")
	public String view(@ModelAttribute Deposite deposite, Model m) {
	    double account = deposite.getAccount();
	    List<Deposite> users = repoo.findByAccount(account); 
	    m.addAttribute("deposite", deposite); 
	    m.addAttribute("users", users);
	    return "Balance"; 
	}

	
	@GetMapping("/view")
	public String view(Model model) {
	    List<Baroda> account = repo.findAll(); 
	    model.addAttribute("account", account); 
	    
	    return "view";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable("id")  int id,Model model)
	{
		Baroda data=repo.findById(id).get();	
		model.addAttribute("data", data);
		return "update";
		
	}
   @PostMapping("update/{id}")
   public String update(@PathVariable("id") int id,@ModelAttribute("account") Baroda account)
   {
	   Baroda data=repo.findById(id).get();	
	   data.setAdhar(account.getAdhar());
	   data.setPan(account.getPan());
	   data.setEmail(account.getEmail());
	   data.setMobile(account.getMobile());
	   data.setAdress(account.getAdress());
	   data.setPin(account.getPin());
	   
	   repo.save(data);
	   return "view";
   }
   
   
   @PostMapping("delete/{id}")
   public String detete(@PathVariable("id") int id)
   {
	   Baroda data=repo.findById(id).get();
	   repo.delete(data);
	   return"redirect:/view";
   }

	
	

}
