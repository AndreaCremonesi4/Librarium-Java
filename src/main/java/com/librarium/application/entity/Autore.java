package com.librarium.application.entity;

public class Autore {
	
	private int id;
	private String nome;
	
	public Autore(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String toString() {
		return "id: " + id + " nome: " + nome;
	}
	
}
