package com.leafsoft.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Main {
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(ModelMap model) {
		
        model.addAttribute("message", "Hello Guest, this is the Home Page...");
        return "index";
    }
    
    @PreAuthorize("hasRole('ROLE_SELLER')")
    @RequestMapping(value = "/seller", method = RequestMethod.GET)
    public String sellerPage(ModelMap model) {
        
        model.addAttribute("message", "Seller Page...");
        return "seller/seller";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_BUYER','ROLE_SELLER')")
    @RequestMapping(value = "/buyer", method = RequestMethod.GET)
    public String buyerPage(ModelMap model) {
        
        model.addAttribute("message", "Buyer Page...");
        return "buyer/buyer";
    }
}