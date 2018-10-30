package com.udemy.in28min.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode=FaultCode.CUSTOM, customFaultCode="{http://in28min.udemy.com/delegate}Course Not Found.")
public class EnhancedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnhancedException(String message, Throwable cause) {
		super(message, cause);
	}

	public EnhancedException(String message) {
		super(message);
	}

	public EnhancedException(Throwable cause) {
		super(cause);
	}
}
