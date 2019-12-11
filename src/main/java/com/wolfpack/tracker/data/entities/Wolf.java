package com.wolfpack.tracker.data.entities;

import com.wolfpack.tracker.data.Gender;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "wolves")
public class Wolf {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "birth_date", nullable = false)
    private java.sql.Date birthDate;

    //region Constructors


    public Wolf() {
    }

    public Wolf(Long id, String firstName, String lastName, Gender gender, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    //endregion

    //region Getters and Setters

    public Long getId() {
        return id;
    }

    public Wolf setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Wolf setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Wolf setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Wolf setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Wolf setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    //endregion
}
