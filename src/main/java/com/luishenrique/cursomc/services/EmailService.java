package com.luishenrique.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.luishenrique.cursomc.domain.Pedido;

public interface EmailService
{
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage message);
}
