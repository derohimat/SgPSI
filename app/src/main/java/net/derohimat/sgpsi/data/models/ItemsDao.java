package net.derohimat.sgpsi.data.models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ItemsDao extends RealmObject {

    @PrimaryKey private long id;
    @SerializedName("timestamp") private String timestamp;
    @SerializedName("update_timestamp") private String updateTimestamp;
    @SerializedName("readings") private ReadingsDao readings;

    public long getId() {
        return id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getUpdateTimestamp() {
        return updateTimestamp;
    }

    public ReadingsDao getReadings() {
        return readings;
    }
}