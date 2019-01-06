package com.gustavo.cursomc.domain.enums;

public enum TipoCliente {
	/**
	 * Tipo enum irá guardar no banco um numero inteiro ou uma String, no caso irei
	 * salvar um codigo para cada tipo enum dessa classe pois isso evita vários
	 * problemas.
	 */
	PESSOAFISICA(1, "PF"), 
	PESSOAJURIDICA(2, "PJ");
	
	private int cod;
	private String descricao;

	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return this.cod;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	/**
	 * Este metodo compara se o codigo existe, compara com os codigos cadastrados e
	 * retorna o mesmo se for verdadeiro.
	 * 
	 * @param cod
	 * @return Retorna o codigo do TipoCliente
	 */
	public static TipoCliente toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
