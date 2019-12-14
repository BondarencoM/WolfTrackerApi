package com.wolfpack.tracker.data.dto;

import com.fasterxml.jackson.annotation.*;
import com.wolfpack.tracker.data.entities.Pack;
import com.wolfpack.tracker.data.entities.Wolf;

import java.util.List;

/**
 * Represents one pack with all the usual properties
 * and has additionally a list of wolves in the pack
 */
public class PackPlusWolvesDTO {

    @JsonUnwrapped
    private Pack pack;
    private List<Wolf> wolves;

    //region constructors
    public PackPlusWolvesDTO(Pack pack, List<Wolf> wolves) {
        this.pack = pack;
        this.wolves = wolves;
    }

    public PackPlusWolvesDTO() {
    }
    //endregion


    //region Getters and Setters
    public Pack getPack() {
        return pack;
    }

    public PackPlusWolvesDTO setPack(Pack pack) {
        this.pack = pack;
        return this;
    }

    public List<Wolf> getWolves() {
        return wolves;
    }

    public PackPlusWolvesDTO setWolves(List<Wolf> wolves) {
        this.wolves = wolves;
        return this;
    }
    //endregion

}
