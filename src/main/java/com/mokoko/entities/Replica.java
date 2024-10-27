package com.mokoko.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "repliche")
public class Replica {
	
	@Id
	@Column(name = "COD_REPLICA", length = 4, nullable = false)
	private String id;
	
	@Column(name = "DATA_REPLICA", nullable = false)
	private Date data;
	
	@Column(name = "POSTI_DISPONIBILI")
    private Integer postiDisponibili;
	
	@ManyToOne
	@JoinColumn(name = "COD_SPETTACOLO", nullable = false)
	private Spettacolo spettacolo;

	public Replica() {
		super();
	}

	public Replica(Date data, Integer postiDisponibili, Spettacolo spettacolo) {
		super();
		this.data = data;
		this.postiDisponibili = postiDisponibili;
		this.spettacolo = spettacolo;	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Spettacolo getSpettacolo() {
		return spettacolo;
	}

	public void setSpettacolo(Spettacolo spettacolo) {
		this.spettacolo = spettacolo;
	}
	
	public Integer getPostiDisponibili() {
		return postiDisponibili;
	}

	public void setPostiDisponibili(Integer postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Replica [id=");
		builder.append(id);
		builder.append(", data=");
		builder.append(data);
		builder.append(", postiDisponibili=");
		builder.append(postiDisponibili);
		builder.append(", spettacolo=");
		builder.append(spettacolo);
		builder.append("]");
		return builder.toString();
	}	
}
