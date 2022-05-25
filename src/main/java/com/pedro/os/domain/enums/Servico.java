package com.pedro.os.domain.enums;

public enum Servico {

	NENHUM(0, "NENHUM SERVIÇO"), ELETRICISTA(1, "ELETRICISTA R$110/H"), PINTOR(2, "PINTOR R$100/H"),
	LIMPEZA(3, "LIMPEZA R$40/H"), VIDRACEIRO(4, "VIDRACEIRO R$200/H"), ENCANADOR(5, "ENCANADOR R$100/H");

	private Integer cod;
	private String descricao;

	private Servico(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Servico toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (Servico x : Servico.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Serviço inválido!" + cod);
	}
}