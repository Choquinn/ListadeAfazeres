package com.examplo.todoapp.model;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private String descricao;
	private LocalDate data;
	private boolean concluida;
	
	public Tarefa() {}
	
	public Tarefa(String titulo, String descricao, LocalDate data, boolean concluida) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.concluida = concluida;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) { 
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public boolean isConcluida() {
		return concluida;
	}
	
	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}
	
	@Override
	public String toString() {
		return "Tarefa{" +
				"id=" + id +
				", titulo='" + titulo + '\'' +
				", descricao='" + descricao + '\'' +
				", data=" + data +
				", concluida=" + concluida +
				'}';
	}
}
