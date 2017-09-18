package net.derohimat.sgpsi.data.models;

import com.google.gson.annotations.SerializedName;

public class ApiInfoDao {

    @SerializedName("status") private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}