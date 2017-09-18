package net.derohimat.sgpsi.data.models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ApiInfoDao extends RealmObject {

    @PrimaryKey private long id;
    @SerializedName("status") private String status;

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}