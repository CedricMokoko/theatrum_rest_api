package com.mokoko.dto;

public class ClienteDTO {
    private Long id;
    private String cognome;
    private String nome;
    private String ruolo;
    private String email;
    private String imagePath;

    
    public ClienteDTO() {}

    public ClienteDTO(Long id,String cognome, String nome, String ruolo, String email, String imagePath) {
		super();
		this.id = id;
		this.cognome = cognome;
		this.nome = nome;
		this.ruolo = ruolo;
		this.email = email;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClienteDTO [id=");
		builder.append(id);
		builder.append(", cognome=");
		builder.append(cognome);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", ruolo=");
		builder.append(ruolo);
		builder.append(", email=");
		builder.append(email);
		builder.append(", imagePath=");
		builder.append(imagePath);
		builder.append("]");
		return builder.toString();
	}
}
