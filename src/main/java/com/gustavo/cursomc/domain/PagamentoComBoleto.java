package com.gustavo.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.gustavo.cursomc.domain.Pagamento;
import com.gustavo.cursomc.domain.Pedido;
import com.gustavo.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	
	private Date dataPagamento;
	
	
	public PagamentoComBoleto() {
		
	}

	// Em construtores de subclasses como esta (que extends uma outra classe)
	// colocamos os atributos da superclasse dentro do contrutor
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento,
			Date dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	
	
	

}
