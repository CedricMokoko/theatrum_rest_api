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
	@Column(name = "id")
	private Long id;
	
	@Column(name = "COGNOME", length = 20, nullable = false)
	private String cognome;
	
	@Column(name = "NOME", length = 20, nullable = false)
	private String nome;
	
	@Column(name = "EMAIL", length = 30, nullable = false)
	private String email;
	
	@Column(name = "PASSWORD", length = 60, nullable = false)
	private String password;
	
	public Cliente() {
		super();
	}

	public Cliente(String cognome, String nome, String email, String password) {
		super();
		this.cognome = cognome;
		this.nome = nome;
		this.email = email;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
	        return password;
	}

    public void setPassword(String password) {
        this.password = password; 
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
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
}
