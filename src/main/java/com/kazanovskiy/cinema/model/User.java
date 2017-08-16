package com.kazanovskiy.cinema.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    private String username;

    private String firstName;

    private String lastName;

    private String phone;

    private String password;

    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

}
