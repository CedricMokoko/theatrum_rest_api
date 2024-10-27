package com.mokoko.entities;

import java.time.LocalDateTime;

import com.mokoko.enums.RatedEntityType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  //Relazione unidirezionale - la classe Rating fa  riferimento alla classe Cliente, ma non il contrario.
  	@ManyToOne
  	@JoinColumn(name = "COD_CLIENTE", nullable = false)
  	private Cliente cliente;

    @Column(nullable = false)
    private Integer ratingValue;

    @Column(nullable = false)
    private String ratedEntityId;

    @Enumerated(EnumType.STRING)
    private RatedEntityType ratedEntityType;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    
    public Rating() {
		super();
	}
    
    public Rating(Cliente cliente, Integer ratingValue, String ratedEntityId, RatedEntityType ratedEntityType,
			LocalDateTime createdAt) {
		super();
		this.cliente = cliente;
		this.ratingValue = ratingValue;
		this.ratedEntityId = ratedEntityId;
		this.ratedEntityType = ratedEntityType;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(Integer ratingValue) {
		this.ratingValue = ratingValue;
	}

	public String getRatedEntityId() {
		return ratedEntityId;
	}

	public void setRatedEntityId(String ratedEntityId) {
		this.ratedEntityId = ratedEntityId;
	}

	public RatedEntityType getRatedEntityType() {
		return ratedEntityType;
	}

	public void setRatedEntityType(RatedEntityType ratedEntityType) {
		this.ratedEntityType = ratedEntityType;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rating [id=");
		builder.append(id);
		builder.append(", cliente=");
		builder.append(cliente);
		builder.append(", ratingValue=");
		builder.append(ratingValue);
		builder.append(", ratedEntityId=");
		builder.append(ratedEntityId);
		builder.append(", ratedEntityType=");
		builder.append(ratedEntityType);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append("]");
		return builder.toString();
	}
   
}

