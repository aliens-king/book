package com.assignment.books.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author SUDHANSHU
 *
 */
@Configuration
public class MailConfig {

	
	@Autowired
	private Environment env;
    
    
    
	/**
	 * @return   JavaMailSender
	 */
	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost(env.getProperty("spring.mail.host"));
		javaMailSenderImpl.setUsername(env.getProperty("spring.mail.username"));
		javaMailSenderImpl.setPassword(env.getProperty("spring.mail.password"));
		javaMailSenderImpl.setPort(Integer.valueOf(env.getProperty("spring.mail.port")));
		

	    Properties props = javaMailSenderImpl.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	    
		return javaMailSenderImpl;
	}

	/**
	 * @return mailMessage
	 */
	@Bean
	public SimpleMailMessage getMailMessage() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("abovoapp@gmail.com");
		return mailMessage;

	}

}
