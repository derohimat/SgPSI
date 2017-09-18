package net.derohimat.sgpsi.data.models;

import com.google.gson.annotations.SerializedName;

public class ReadingDao {

    @SerializedName("national") private double national;
    @SerializedName("south") private double south;
    @SerializedName("north") private double north;
    @SerializedName("east") private double east;
    @SerializedName("central") private double central;
    @SerializedName("west") private double west;

    public double getNational() {
        return national;
    }

    public void setNational(double national) {
        this.national = national;
    }

    public double getSouth() {
        return south;
    }

    public void setSouth(double south) {
        this.south = south;
    }

    public double getNorth() {
        return north;
    }

    public void setNorth(double north) {
        this.north = north;
    }

    public double getEast() {
        return east;
    }

    public void setEast(double east) {
        this.east = east;
    }

    public double getCentral() {
        return central;
    }

    public void setCentral(double central) {
        this.central = central;
    }

    public double getWest() {
        return west;
    }

    public void setWest(double west) {
        this.west = west;
    }
}