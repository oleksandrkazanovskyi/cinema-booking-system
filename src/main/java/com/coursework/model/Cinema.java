package com.coursework.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cinema {
    private int cinemaId;
    private String title;
    private String address;
    private String telephoneNumber;
    private String email;
    private Set<Hall> hall;

    public Cinema() {
    }

    @Id
    @GeneratedValue
    @Column(name = "Cinema_ID")
    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String cinemaAdress) {
        this.address = cinemaAdress;
    }

    @Column(name = "Telephone_Number")
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Column(name = "E_mail")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @OneToMany(mappedBy = "cinema")
    public Set<Hall> getHall() {
        return hall;
    }

    public void setHall(Set<Hall> hall) {
        this.hall = hall;
    }

    @Override
    public String toString() {
        return title;
    }
}
