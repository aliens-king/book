package com.assignment.books.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SmtpMailSender {
	@Autowired
	private JavaMailSender javaMailSender;

	/**
	 * @param to
	 * @param subject
	 * @param body
	 */
	public void send(String to,String subject,String body) {
		try {	
		MimeMessage msg=javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		
			helper=new MimeMessageHelper(msg,true);
			helper.setSubject(subject);
			helper.setTo(to);
			helper.setText(body,true);
			javaMailSender.send(msg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
