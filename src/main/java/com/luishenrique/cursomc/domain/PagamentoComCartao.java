package com.luishenrique.cursomc.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.luishenrique.cursomc.domain.enums.EstadoPagamento;

@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento
{
	private static final long serialVersionUID = 1L;
	private Integer numeroDeParcelas;

	public PagamentoComCartao()
	{

	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado_pagamento, Pedido pedido, Integer numeroDeParcelas)
	{
		super(id, estado_pagamento, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas()
	{
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas)
	{
		this.numeroDeParcelas = numeroDeParcelas;
	}

}
