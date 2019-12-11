package com.wolfpack.tracker.data.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "packs")
public class Pack {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    //region Constructors

        public Pack() {
        }

        public Pack(Long id, String name) {
        this.id = id;
        this.name = name;
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

    //endregion
}
