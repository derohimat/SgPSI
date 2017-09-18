package net.derohimat.sgpsi.data.models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ReadingDao extends RealmObject {

    @PrimaryKey private long id;
    @SerializedName("national") private double national;
    @SerializedName("south") private double south;
    @SerializedName("north") private double north;
    @SerializedName("east") private double east;
    @SerializedName("central") private double central;
    @SerializedName("west") private double west;

    public long getId() {
        return id;
    }

    public double getNational() {
        return national;
    }

    public double getSouth() {
        return south;
    }

    public double getNorth() {
        return north;
    }

    public double getEast() {
        return east;
    }

    public double getCentral() {
        return central;
    }

    public double getWest() {
        return west;
    }
}