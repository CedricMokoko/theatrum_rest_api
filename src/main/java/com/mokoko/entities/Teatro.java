package com.mokoko.entities;

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
@Table(name = "Teatri")
public class Teatro {

    @Id
    @Column(name = "COD_TEATRO", length = 4)
    private String id; 

    @Column(name = "NOME", length = 50, nullable = false)
    private String nome; 
    
    @Column(name = "INDIRIZZO", length = 30, nullable = false)
    private String indirizzo;  

    @Column(name = "PROVINCIA", length = 2, nullable = false)
    private String provincia; 

    @Column(name = "TELEFONO", length = 14)
    private String telefono; 

    @Column(name = "POSTI")
    private Integer posti;
    
    @Column(name = "IMAGE_PATH", length = 255, nullable = true) // Ajout du champ pour l'image
	private String imagePath; // Champ pour stocker le chemin de l'image

    
    @OneToMany(mappedBy = "COD_TEATRO", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rating> ratings;
    
    @ManyToOne
	@JoinColumn(name = "COD_CITTA", nullable = false)
	private Citta citta;
    
	public Teatro() {
		super();
	}

	public Teatro(String nome, String indirizzo, String provincia, String telefono, Integer posti, String imagePath,
			List<Rating> ratings, Citta citta) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.provincia = provincia;
		this.telefono = telefono;
		this.posti = posti;
		this.imagePath = imagePath;
		this.ratings = ratings;
		this.citta = citta;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getPosti() {
		return posti;
	}

	public void setPosti(Integer posti) {
		this.posti = posti;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Citta getCitta() {
		return citta;
	}

	public void setCitta(Citta citta) {
		this.citta = citta;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Teatro [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", indirizzo=");
		builder.append(indirizzo);
		builder.append(", provincia=");
		builder.append(provincia);
		builder.append(", telefono=");
		builder.append(telefono);
		builder.append(", posti=");
		builder.append(posti);
		builder.append(", imagePath=");
		builder.append(imagePath);
		builder.append(", ratings=");
		builder.append(ratings);
		builder.append(", citta=");
		builder.append(citta);
		builder.append("]");
		return builder.toString();
	}

}
