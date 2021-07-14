package com.luishenrique.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.luishenrique.cursomc.domain.Pedido;

public interface EmailService
{
	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage message);

	void sendOrderConfirmationHtmlEmail(Pedido obj);

	void sendHtmlEmail(MimeMessage msg);

}
