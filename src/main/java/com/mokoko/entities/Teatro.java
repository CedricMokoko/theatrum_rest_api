package com.mokoko.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    @Column(name = "CITTA", length = 25, nullable = false)
    private String citta; 

    @Column(name = "PROVINCIA", length = 2, nullable = false)
    private String provincia; 

    @Column(name = "TELEFONO", length = 14)
    private String telefono; 

    @Column(name = "POSTI")
    private Integer posti;
    

	public Teatro() {
		super();
	}

	public Teatro(String nome, String indirizzo, String citta, String provincia, String telefono, Integer posti) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.provincia = provincia;
		this.telefono = telefono;
		this.posti = posti;
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

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Teatro [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", indirizzo=");
		builder.append(indirizzo);
		builder.append(", citta=");
		builder.append(citta);
		builder.append(", provincia=");
		builder.append(provincia);
		builder.append(", telefono=");
		builder.append(telefono);
		builder.append(", posti=");
		builder.append(posti);
		builder.append("]");
		return builder.toString();
	}   
}
