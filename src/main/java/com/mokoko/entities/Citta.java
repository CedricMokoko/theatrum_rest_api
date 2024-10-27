package com.mokoko.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "citta")
public class Citta {
    
    @Id
    @Column(name = "COD_CITTA", length = 4, nullable = false)
    private String id;
    
    @Column(name = "NOME", length = 20, nullable = false)
    private String nome;
    
    @Column(name = "DESCRIPTION", length = 255, nullable = false)
    private String description;
    
    @Column(name = "IMAGE_URL", length = 255, nullable = true)
    private String imageUrl;
    
    @OneToMany(mappedBy = "COD_CITTA", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rating> ratings;

    public Citta() {
		super();
	}

	public Citta(String nome, String description, String imageUrl, List<Rating> ratings) {
		super();
		this.nome = nome;
		this.description = description;
		this.imageUrl = imageUrl;
		this.ratings = ratings;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    // Calcola il punteggio medio dei rating
    public double calcolaRatingMedio() {
        if (ratings == null || ratings.isEmpty()) {
            return 0;
        }
        return ratings.stream()
                .mapToInt(Rating::getRatingValue)
                .average()
                .orElse(0);
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Citta [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", description=");
		builder.append(description);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append(", ratings=");
		builder.append(ratings);
		builder.append("]");
		return builder.toString();
	}  
}
