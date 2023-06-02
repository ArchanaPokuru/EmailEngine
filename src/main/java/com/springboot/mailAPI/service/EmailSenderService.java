package com.springboot.mailAPI.service;

import com.springboot.mailAPI.Module.EmailDetails;

public interface EmailSenderService 
{
	 String sendSimpleMail(EmailDetails details);
	 String sendMailWithAttachment(EmailDetails details);
}
