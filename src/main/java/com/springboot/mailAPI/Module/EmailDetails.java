package com.springboot.mailAPI.Module;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="EmailDetails")
public class EmailDetails 
{	
	@Id 
	private String subject;
	private String recipient;
	private String msgBody;
	private String cc;
	private String bcc;
	private String attachement;
}
