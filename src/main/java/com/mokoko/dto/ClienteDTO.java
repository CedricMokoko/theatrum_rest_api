package com.mokoko.dto;

public class ClienteDTO {
    private Long id;
    private String cognome;
    private String nome;
    private String email;
    private String ruolo;

    
    public ClienteDTO() {}
    
    public ClienteDTO(Long id, String cognome, String nome, String email, String ruolo) {
        this.id = id;
        this.cognome = cognome;
        this.nome = nome;
        this.email = email;
        this.ruolo = ruolo;
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

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
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
		builder.append(", email=");
		builder.append(email);
		builder.append(", ruolo=");
		builder.append(ruolo);
		builder.append("]");
		return builder.toString();
	}
    
}
