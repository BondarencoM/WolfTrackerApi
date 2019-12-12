package com.wolfpack.tracker.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wolfpack.tracker.data.Gender;
import com.wolfpack.tracker.data.entities.embeddable.Coordinates;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "wolves")
@Where(clause = "is_deleted = false")
@SQLDelete(sql = "UPDATE wolves SET is_deleted = true WHERE id = ?")
public class Wolf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Embedded
    private Coordinates location;

    @JsonIgnore
    @Column(name = "is_deleted")
    private boolean deleted;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private Pack pack;

    //region Constructors


    public Wolf() {
    }

    public Wolf(Long id, String firstName, String lastName, Gender gender, Date birthDate, Coordinates location, boolean deleted, Pack pack) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.location = location;
        this.deleted = deleted;
        this.pack = pack;
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

    public Pack getPack() {
        return pack;
    }

    public Wolf setPack(Pack pack) {
        this.pack = pack;
        return this;
    }

    public Coordinates getLocation() {
        return location;
    }

    public Wolf setLocation(Coordinates location) {
        this.location = location;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Wolf setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }


    //endregion
}
