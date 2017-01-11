package com.coursework.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Discount {
    private int discountId;
    private String description;
    private int percent;
    private String tittle;

    public Discount() {
    }


    @Id
    @GeneratedValue
    @Column(name = "Discount_ID")
    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }


    @Column(name = "Desctiption")
    public String getDescription() {
        return description;
    }

    public void setDescription(String desctiption) {
        this.description = desctiption;
    }


    @Column(name = "Percent")
    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    @Column(name = "tittle")
    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discount discount = (Discount) o;

        if (discountId != discount.discountId) return false;
        if (percent != discount.percent) return false;
        return description != null ? description.equals(discount.description) : discount.description == null && (tittle != null ? tittle.equals(discount.tittle) : discount.tittle == null);

    }

    @Override
    public int hashCode() {
        int result = discountId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + percent;
        result = 31 * result + (tittle != null ? tittle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "Description='" + description + '\'' +
                ", Percent=" + percent +
                ", Tittle='" + tittle + '\'' +
                '}';
    }

}
