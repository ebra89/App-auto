package com.atoninformatica.appauto.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Car {


    @Id
    @NotEmpty(message = "campo non puo essere vuoto")
    private String targa;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty(message = "campo non puo essere vuoto")
    private String marca;
    @NotEmpty(message = "campo non puo essere vuoto")
    private String modello;
    @NotEmpty(message = "campo non puo essere vuoto")
    private String immatData;
    @ManyToOne
    private City city;
    @ManyToMany(cascade =CascadeType.ALL )
    @JoinTable(name = "CAR_OWNERS", joinColumns = {
         @JoinColumn(name = "TARGA_CAR",referencedColumnName = "targa")},
            inverseJoinColumns = {@JoinColumn(name = "OWNER_ID", referencedColumnName = "idOwner")})
    private List<Owner> owners;

    public Car(String targa, String marca, String modello, String immatData, City city, List<Owner> owners) {
        this.targa = targa;
        this.marca = marca;
        this.modello = modello;
        this.immatData = immatData;
        this.city = city;
        this.owners = owners;
    }

    public Car() {
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getImmatData() {
        return immatData;
    }

    public void setImmatData(String immatData) {
        this.immatData = immatData;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Car{" +
                "targa='" + targa + '\'' +
                ", marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", immatData='" + immatData + '\'' +
                ", city=" + city +
                ", owners=" + owners +
                '}';
    }
}
