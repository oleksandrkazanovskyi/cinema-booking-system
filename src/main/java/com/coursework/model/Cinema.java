package com.coursework.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Cinema {
    private int cinemaId;
    private String cinemaTittle;
    private String cinemaAdress;
    private String telephoneNumber;
    private String eMail;
    private Set<Hall> hall;

    public Cinema() {
    }

    public Cinema(String cinemaTittle, String cinemaAdress, String telephoneNumber, String eMail) {
        this.cinemaTittle = cinemaTittle;
        this.cinemaAdress = cinemaAdress;
        this.telephoneNumber = telephoneNumber;
        this.eMail = eMail;
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

    @Column(name = "Cinema_Tittle")
    public String getCinemaTittle() {
        return cinemaTittle;
    }

    public void setCinemaTittle(String cinemaTittle) {
        this.cinemaTittle = cinemaTittle;
    }

    @Column(name = "Cinema_Adress")
    public String getCinemaAdress() {
        return cinemaAdress;
    }

    public void setCinemaAdress(String cinemaAdress) {
        this.cinemaAdress = cinemaAdress;
    }

    @Column(name = "Telephone_Number")
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Column(name = "E_mail")
    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
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
        return cinemaTittle;
    }
}
