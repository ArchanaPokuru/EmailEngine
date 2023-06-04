package com.kloc.emailApp.service;

import com.kloc.emailApp.entity.EmailDetails;

public interface EmailService {
	String sendSimplemail(EmailDetails details);
	
	String sendMailWithAttachment(EmailDetails details);
	

}
