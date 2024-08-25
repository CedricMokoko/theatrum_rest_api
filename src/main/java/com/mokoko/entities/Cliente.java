package com.mokoko.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clienti")
public class Cliente {
	
	@Id //per segnare quest'attributo come chiave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_CLIENTE")
	private Long id;
	
	@Column(name = "COGNOME", length = 20, nullable = false)
	private String cognome;
	
	@Column(name = "NOME", length = 20, nullable = false)
	private String nome;
	
	@Column(name = "TELEFONO", length = 14, nullable = true)
	private String telefono;
	
	@Column(name = "EMAIL", length = 30, nullable = false)
	private String email;
	
	public Cliente() {
		super();
	}

	public Cliente(String cognome, String nome, String telefono, String email) {
		super();
		this.cognome = cognome;
		this.nome = nome;
		this.telefono = telefono;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [id=");
		builder.append(id);
		builder.append(", cognome=");
		builder.append(cognome);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", telefono=");
		builder.append(telefono);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
	
	

}
