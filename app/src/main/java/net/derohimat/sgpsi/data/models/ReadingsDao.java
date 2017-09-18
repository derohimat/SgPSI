package net.derohimat.sgpsi.data.models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ReadingsDao extends RealmObject {

    @PrimaryKey private long id;
    @SerializedName("o3_sub_index") private ReadingDao o3SubIndex;
    @SerializedName("pm10_twenty_four_hourly") private ReadingDao pm10Daily;
    @SerializedName("pm10_sub_index") private ReadingDao pm10SubIndex;
    @SerializedName("co_sub_index") private ReadingDao coSubIndex;
    @SerializedName("pm25_twenty_four_hourly") private ReadingDao pm25Daily;
    @SerializedName("co_eight_hour_max") private ReadingDao coEightHourMax;
    @SerializedName("so2_twenty_four_hourly") private ReadingDao so2Daily;
    @SerializedName("pm25_sub_index") private ReadingDao pm25SubIndex;
    @SerializedName("psi_twenty_four_hourly") private ReadingDao psiDaily;
    @SerializedName("o3_eight_hour_max") private ReadingDao o3EightHourMax;

    public ReadingDao getO3SubIndex() {
        return o3SubIndex;
    }

    public ReadingDao getPm10Daily() {
        return pm10Daily;
    }

    public ReadingDao getPm10SubIndex() {
        return pm10SubIndex;
    }

    public ReadingDao getCoSubIndex() {
        return coSubIndex;
    }

    public ReadingDao getPm25Daily() {
        return pm25Daily;
    }

    public ReadingDao getCoEightHourMax() {
        return coEightHourMax;
    }

    public ReadingDao getSo2Daily() {
        return so2Daily;
    }

    public ReadingDao getPm25SubIndex() {
        return pm25SubIndex;
    }

    public ReadingDao getPsiDaily() {
        return psiDaily;
    }

    public ReadingDao getO3EightHourMax() {
        return o3EightHourMax;
    }
}