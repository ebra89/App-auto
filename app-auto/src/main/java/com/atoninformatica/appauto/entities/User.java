package com.atoninformatica.appauto.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUser;
    @Id
    @Email
    @Column(unique = true)
    @NotEmpty(message = "campo non puo essere vuoto")
    private String email;
    @NotEmpty(message = "campo non puo essere vuoto")
    @Size(min = 5,message = "password di almeno 5 cartteri")
    private String password;
    private String nome;
    @NotEmpty(message = "campo non puo essere vuoto")
    private String cognome;
    @NotEmpty(message = "campo non puo essere vuoto")
    private String dataNascita;
    @ManyToOne
    private City city;

    private String status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",joinColumns = {
            @JoinColumn(name = "USER_EMAIL", referencedColumnName = "email")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_NOME", referencedColumnName = "nome")})
    private List<Role>roles;

    public User() {
    }

    public User(String email,String password, String nome, String cognome, String dataNascita, City city, String status, List<Role> roles) {
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.city = city;
        this.status = status;
        this.roles = roles;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita='" + dataNascita + '\'' +
                ", city=" + city +
                ", status='" + status + '\'' +
                ", roles=" + roles +
                '}';
    }
}
