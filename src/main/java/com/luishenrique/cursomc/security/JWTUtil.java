package com.luishenrique.cursomc.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil
{
	@Value("${jwt.secret}")
	private String segredo;
	@Value("${jwt.expiration}")
	private Long expiration;

	public JWTUtil()
	{

	}

	public String generateToken(String username)
	{
		return Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, segredo.getBytes()).compact();
	}
}
