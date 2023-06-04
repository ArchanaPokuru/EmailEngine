package com.kloc.emailApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kloc.emailApp.entity.EmailDetails;
import com.kloc.emailApp.service.EmailService;

@RestController
public class EmailController {
	@Autowired
	private EmailService emailService;
	
	// to send a simple mail
	@PostMapping("/sendmail")
	public String sendEmail(@RequestBody EmailDetails details) {
		String status = emailService.sendSimplemail(details);
		
		return status;
	}
	//to send mail with attachment
	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(@RequestBody EmailDetails details) {
		String status = emailService.sendMailWithAttachment(details);
		return status;
	}
	
	//to send mail to multiple users
	
	
}
