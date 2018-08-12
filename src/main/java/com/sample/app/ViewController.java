/**
 * 
 */
package com.sample.app;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sample.app.autoreturn.AccountAutoReturnRegistrationForm;
import com.sample.app.publisher.AccountPublisherRegistrationForm;
import com.sample.app.publishercommonevent.AccountPublisherCommonRegistrationForm;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ViewController {
	
	private final AccountService accountService;
	
	@GetMapping({"/", "index"})
	public String viewHomePage(@ModelAttribute("registrationARForm") AccountAutoReturnRegistrationForm registrationARForm,
			@ModelAttribute("registrationPForm") AccountPublisherRegistrationForm registrationPForm,
			@ModelAttribute("registrationPCForm") AccountPublisherCommonRegistrationForm registrationPCForm) {
		return "index";
	}
	
	@PostMapping("/register")
	public String processAccount(@ModelAttribute("registrationARForm") @Valid AccountAutoReturnRegistrationForm registrationARForm, 
			BindingResult result, Model model) {

		if (!result.hasErrors()) {
			this.accountService.createUserAccount(registrationARForm);
		} 
		
		return "redirect:index";
	}
	
	@PostMapping("/registerPublisher")
	public String processAccountPublisher(@ModelAttribute("registrationPForm") @Valid AccountPublisherRegistrationForm registrationPForm, 
			BindingResult result, Model model) {

		if (!result.hasErrors()) {
			this.accountService.createUserAccountPublisher(registrationPForm);
		} 
		
		return "redirect:index";
	}
	
	@PostMapping("/registerPublisherCommon")
	public String processAccountPublisherCommon(@ModelAttribute("registrationPCForm") @Valid AccountPublisherCommonRegistrationForm registrationPCForm, 
			BindingResult result, Model model) {

		if (!result.hasErrors()) {
			this.accountService.createUserAccountPublisherCommon(registrationPCForm);
		} 
		
		return "redirect:index";
	}
}
