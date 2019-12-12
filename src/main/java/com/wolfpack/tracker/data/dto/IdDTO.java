package com.wolfpack.tracker.data.dto;

public class IdDTO {
    private Long id;

    public IdDTO(Long id) {
        this.id = id;
    }

    public IdDTO() {
    }

    public Long getId() {
        return id;
    }

    public IdDTO setId(Long id) {
        this.id = id;
        return this;
    }
}
