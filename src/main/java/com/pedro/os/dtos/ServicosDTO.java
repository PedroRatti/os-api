package com.pedro.os.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pedro.os.domain.OS;
import com.pedro.os.domain.Servicos;

public class ServicosDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "servicos")
	private List<OS> list = new ArrayList<>();

	private Integer id;
	
	@NotEmpty(message = "O campo NOME é requerido")
	private String nome;

	@NotEmpty(message = "O campo Custo é requerido")
	private String custo;
	
	@NotEmpty(message = "O campo TELEFONE é requerido")
	private String telefone;

	public ServicosDTO() {
		super();
	}

	public ServicosDTO(Servicos obj) {

		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.custo = obj.getCusto();
		this.telefone = obj.getTelefone();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCusto() {
		return custo;
	}

	public void setCusto(String custo) {
		this.custo = custo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public List<OS> getList() {
		return list;
	}

	public void setList(List<OS> list) {
		this.list = list;
	}

}