package com.pedro.os.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Servicos implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//@JsonIgnore
	//@OneToMany(mappedBy = "servicos")
	//private List<Servicos> list = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	private String custo;
	private String telefone;
	
	public Servicos() {
		super();
	}

	public Servicos(Integer id, String nome, String custo, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.custo = custo;
		this.telefone = telefone;
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
	
//	public List<Servicos> getList() {
//		return list;
//	}
//
//	public void setList(List<Servicos> list) {
//		this.list = list;
//	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
