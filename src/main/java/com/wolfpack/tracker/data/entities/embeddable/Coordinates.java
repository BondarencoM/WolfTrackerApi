package com.wolfpack.tracker.data.entities.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class Coordinates {
    private Double latitude;
    private Double longitude;

    //region Constructors

    public Coordinates() {
    }

    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //endregion

    //region Getters and Setters

    public double getLatitude() {
        return latitude;
    }

    public Coordinates setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public double getLongitude() {
        return longitude;
    }

    public Coordinates setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }


    //endregion
}
