package com.luishenrique.cursomc.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.luishenrique.cursomc.domain.Pedido;

public abstract class AbstractEmailService implements EmailService
{
	@Value("${default.sender}")
	private String sender;

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendOrderConfirmationEmail(Pedido obj)
	{
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj)
	{
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getCliente().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Pedido confirmado! Código: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}

	protected String htmlFromTemplatePedido(Pedido obj)
	{
		Context context = new Context();
		context.setVariable("pedido", obj);
		return templateEngine.process("email/confirmacaoPedido", context);
	}

	@Override
	public void sendOrderConfirmationHtmlEmail(Pedido obj)
	{
		try
		{
			MimeMessage mimeMessager = prepareMimeMessageFromPedido(obj);
			sendHtmlEmail(mimeMessager);
		} catch (MessagingException e)
		{
			sendOrderConfirmationEmail(obj);
		}

	}

	protected MimeMessage prepareMimeMessageFromPedido(Pedido obj) throws MessagingException
	{
		MimeMessage mimeMessager = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessagerHelper = new MimeMessageHelper(mimeMessager, true);
		mimeMessagerHelper.setTo(obj.getCliente().getEmail());
		mimeMessagerHelper.setFrom(sender);
		mimeMessagerHelper.setSubject("Pedido Confirmado! Código: " + obj.getId());
		mimeMessagerHelper.setSentDate(new Date(System.currentTimeMillis()));
		mimeMessagerHelper.setText(htmlFromTemplatePedido(obj), true);

		return mimeMessager;
	}
}
