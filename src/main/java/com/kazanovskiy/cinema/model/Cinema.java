package com.kazanovskiy.cinema.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)

public class Cinema extends BaseEntity {

    private String title;
    private String address;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "cinema")
    private Set<Hall> halls;

}
