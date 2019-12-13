package com.wolfpack.tracker.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wolfpack.tracker.data.Gender;
import com.wolfpack.tracker.data.entities.embeddable.Coordinates;
import com.wolfpack.tracker.data.validation.ValueOfEnum;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Column(name = "gender", nullable = false)
    @NotBlank(message = "Gender cannot be null, but you can set it to 'NotSpecified'")
    @ValueOfEnum(enumClass = Gender.class, message = "must be any of [Female, Male, NotSpecified, Other]")
    private String gender;

    @NotNull(message = "Birsth date is mandatory")
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

    public Wolf(Long id, String firstName, String lastName, String gender, Date birthDate, Coordinates location, boolean deleted, Pack pack) {
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
        return Gender.valueOf(gender);
    }

    public Wolf setGender(Gender gender) {
        this.gender = gender.name();
        return this;
    }

    private Wolf setGender(String gender) {
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
