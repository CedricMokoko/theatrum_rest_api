package com.mokoko.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "spettacoli")
public class Spettacolo {
	
	@Id
	@Column(name = "COD_SPETTACOLO", length = 4, nullable = false)
	private String id;
	
	@Column(name = "TITOLO", length = 100, nullable = false)
	private String titolo;
	
	@Column(name = "AUTORE", length = 25, nullable = false)
	private String autore;
	
	@Column(name = "REGISTA", length = 25, nullable = false)
	private String regista;
	
	@Column(name = "PREZZO", nullable = false, precision = 6, scale = 2)
	private BigDecimal prezzo; // Precisione totale: 6, Scala: 2
	 
	@ManyToOne
	@JoinColumn(name = "COD_TEATRO", nullable = false)
	private Teatro teatro;

	public Spettacolo() {
		super();
	}
	
	public Spettacolo(String titolo, String autore, String regista, BigDecimal prezzo, Teatro teatro) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.regista = regista;
		this.prezzo = prezzo;
		this.teatro = teatro;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getRegista() {
		return regista;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	public Teatro getTeatro() {
		return teatro;
	}

	public void setTeatro(Teatro teatro) {
		this.teatro = teatro;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Spettacolo [id=");
		builder.append(id);
		builder.append(", titolo=");
		builder.append(titolo);
		builder.append(", autore=");
		builder.append(autore);
		builder.append(", regista=");
		builder.append(regista);
		builder.append(", prezzo=");
		builder.append(prezzo);
		builder.append(", teatro=");
		builder.append(teatro);
		builder.append("]");
		return builder.toString();
	}
}
