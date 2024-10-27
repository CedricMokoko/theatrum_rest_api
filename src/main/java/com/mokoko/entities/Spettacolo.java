package com.mokoko.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	 
	@Column(name = "IMAGE_PATH", length = 255, nullable = true) // Ajout du champ pour l'image
	private String imagePath; // Champ pour stocker le chemin de l'image

	@ManyToOne
	@JoinColumn(name = "COD_TEATRO", nullable = false)
	private Teatro teatro;
	
	 @OneToMany(mappedBy = "COD_SPETTACOLO", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private List<Rating> ratings;


	public Spettacolo() {
		super();
	}


	public Spettacolo(String titolo, String autore, String regista, BigDecimal prezzo, String imagePath, Teatro teatro,
			List<Rating> ratings) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.regista = regista;
		this.prezzo = prezzo;
		this.imagePath = imagePath;
		this.teatro = teatro;
		this.ratings = ratings;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Teatro getTeatro() {
		return teatro;
	}

	public void setTeatro(Teatro teatro) {
		this.teatro = teatro;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

}
