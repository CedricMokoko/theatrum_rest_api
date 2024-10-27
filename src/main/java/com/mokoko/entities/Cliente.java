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
	
	@Id // pour marquer cet attribut comme clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "COGNOME", length = 20, nullable = false)
	private String cognome;
	
	@Column(name = "NOME", length = 20, nullable = false)
	private String nome;
	
	@Column(name = "RUOLO", length = 20, nullable = true)
	private String ruolo;
	
	@Column(name = "EMAIL", length = 30, nullable = false, unique = true)
	private String email;
	
	@Column(name = "PASSWORD", length = 60, nullable = false)
	private String password;

	@Column(name = "IMAGE_PATH", length = 255, nullable = true) // Ajout du champ pour l'image
	private String imagePath; // Champ pour stocker le chemin de l'image

	public Cliente() {
		super();
	}

	public Cliente(String cognome, String nome, String ruolo, String email, String password, String imagePath) {
		super();
		this.cognome = cognome;
		this.nome = nome;
		this.ruolo = ruolo;
		this.email = email;
		this.password = password;
		this.imagePath = imagePath;
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

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
		builder.append(", ruolo=");
		builder.append(ruolo);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", imagePath=");
		builder.append(imagePath);
		builder.append("]");
		return builder.toString();
	}
}
