package com.mokoko.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterDTO {

    @NotBlank(message = "Il cognome non può essere vuoto")
    @Size(max = 20, message = "Il cognome non può essere più lungo di 20 caratteri")
    private String cognome;

    @NotBlank(message = "Il nome non può essere vuoto")
    @Size(max = 20, message = "Il nome non può essere più lungo di 20 caratteri")
    private String nome;

    @NotBlank(message = "L'email non può essere vuota")
    @Email(message = "L'email deve essere valida")
    @Size(max = 30, message = "L'email non può essere più lunga di 30 caratteri")
    private String email;

    @NotBlank(message = "La password non può essere vuota")
    @Size(min = 8, message = "La password deve avere almeno 8 caratteri")
    private String password;

    public RegisterDTO() {}

    public RegisterDTO(String cognome, String nome, String email, String password) {
        this.cognome = cognome;
        this.nome = nome;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegisterDTO{" +
                "cognome='" + cognome + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
