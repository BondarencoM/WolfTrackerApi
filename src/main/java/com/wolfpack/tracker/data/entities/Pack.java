package com.wolfpack.tracker.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "packs")
@Where(clause = "is_deleted = false")
@SQLDelete(sql = "UPDATE packs SET is_deleted = true WHERE id = ?")
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Pack name is mandatory")
    private String name;

    @JsonIgnore
    @Column(name = "is_deleted")
    private boolean deleted;

    //region Constructors

        public Pack() {
        }

        public Pack(Long id, String name, boolean deleted) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
        }

    //endregion

    //region Getters and Setters

        public Long getId() {
            return id;
        }

        public Pack setId(Long id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public Pack setName(String name) {
            this.name = name;
            return this;
        }

        public boolean isDeleted() {
            return deleted;
        }

        public Pack setDeleted(boolean deleted) {
            this.deleted = deleted;
            return this;
        }

    //endregion
}
