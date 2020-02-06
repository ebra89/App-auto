package com.atoninformatica.appauto.entities;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idOwner;
    @NotEmpty(message = "campo non puo essere vuoto")
    private String nome;
    @NotEmpty(message = "campo non puo essere vuoto")
    private String cognome;
    @NotEmpty(message = "campo non puo essere vuoto")
    private String dataNascita;
    @ManyToOne
    private City city;
    @ManyToMany(mappedBy = "owners")
    private List<Car>cars;
    @ManyToOne
    private User user;

    public Owner() {
    }

    public Owner(int idOwner, String nome, String cognome, String dataNascita, City city, List<Car> cars, User user) {
        this.idOwner = idOwner;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.city = city;
        this.cars = cars;
        this.user = user;
    }

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "idOwner=" + idOwner +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita='" + dataNascita + '\'' +
                ", city=" + city +
                ", cars=" + cars +
                ", user=" + user +
                '}';
    }
}
