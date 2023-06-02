package com.springboot.mailAPI.service.serviceimpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.springboot.mailAPI.Module.EmailDetails;
import com.springboot.mailAPI.Repository.repository;
import com.springboot.mailAPI.service.EmailSenderService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

// Annotation
@Service
// Class
// Implementing EmailService interface
public class EmailSenderServiceImpl implements EmailSenderService {
	@Autowired
	private repository rep;
	

	public EmailSenderServiceImpl(repository rep) {
		super();
		this.rep = rep;
	}

	@Autowired private JavaMailSender javaMailSender;
 
    @Value("${spring.mail.username}") private String sender;
 
    // Method 1
    // To send a simple email
    public String sendSimpleMail(EmailDetails details)
    {
    	
 
        // Try block to check for exceptions
        try {
        	 
            // Creating a simple mail message
            SimpleMailMessage mailMessage
                = new SimpleMailMessage();
 
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setCc(details.getCc());
            mailMessage.setBcc(details.getBcc());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());
            
            // Sending the mail
            javaMailSender.send(mailMessage);
        	rep.save(details);
            return "Mail Sent Successfully...";
        }
 
        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }
 
    // Method 2
    // To send an email with attachment
    public String
    sendMailWithAttachment(EmailDetails details)
    {
    	
        // Creating a mime message
        MimeMessage mimeMessage
            = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
 
        try {
 
            // Setting multipart as true for attachments to
            // be send
        	 
            mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setCc(details.getCc());
            mimeMessageHelper.setBcc(details.getBcc());           
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(
                details.getSubject());
 
            // Adding the attachment
            FileSystemResource file
                = new FileSystemResource(
                     new File(details.getAttachement()));
 
            mimeMessageHelper.addAttachment(
                file.getFilename(), file);
 
            // Sending the mail
            javaMailSender.send(mimeMessage);
        	rep.save(details);
            return "Mail sent Successfully";
        }
 
        // Catch block to handle MessagingException
        catch (MessagingException e) {
 
            // Display message when exception occurred
            return "Error while sending mail!!!";
        }
    }

	
}
