package com.atoninformatica.appauto.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCitta;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String provincia;
    @NotEmpty
    private String stato;

    public City() {
    }

    public City(int idCitta, String nome, String provincia, String stato) {
        this.idCitta = idCitta;
        this.nome = nome;
        this.provincia = provincia;
        this.stato = stato;
    }

    public int getIdCitta() {
        return idCitta;
    }

    public void setIdCitta(int idCitta) {
        this.idCitta = idCitta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "City{" +
                "idCitta=" + idCitta +
                ", nome='" + nome + '\'' +
                ", provincia='" + provincia + '\'' +
                ", stato='" + stato + '\'' +
                '}';
    }
}
