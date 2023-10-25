package com.ilker.ValidationDemo.mvc.Controller;

import com.ilker.ValidationDemo.mvc.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("customer",new Customer());
        return "customer-form";
    }
    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer,BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "customer-form";
        else
            return "customer-confirmation";
    }
}