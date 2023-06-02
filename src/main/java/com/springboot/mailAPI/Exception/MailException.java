package com.springboot.mailAPI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class MailException extends RuntimeException
{
	private String resourceName;
	private String filename;
	private Object fieldvalue;
	public MailException(String resourceName, String filename, Object fieldvalue) {
		super(String.format("%s not found with %s : '%s'",resourceName,filename,fieldvalue));
		this.resourceName = resourceName;
		this.filename = filename;
		this.fieldvalue = fieldvalue;
	}
	public String getResourceName() {
		return resourceName;
	}
	public String getFilename() {
		return filename;
	}
	public Object getFieldvalue() {
		return fieldvalue;
	}
}
