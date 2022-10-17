package com.example.reto3jose.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;

    @ManyToOne
    @JoinColumn(name = "gamaId")
    @JsonIgnoreProperties("cars")
    private Gama gama;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "car")
    @JsonIgnoreProperties({"car", "messages"})
    public List<Reservation> reservations;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "car")
    @JsonIgnoreProperties({"car", "client"})
    public List<Message> messages;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Gama getGama() {
        return gama;
    }

    public void setGama(Gama gama) {
        this.gama = gama;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
