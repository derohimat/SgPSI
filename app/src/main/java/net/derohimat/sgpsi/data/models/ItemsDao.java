package net.derohimat.sgpsi.data.models;

import com.google.gson.annotations.SerializedName;

public class ItemsDao {

    @SerializedName("timestamp") private String timestamp;
    @SerializedName("update_timestamp") private String updateTimestamp;
    @SerializedName("readings") private ReadingsDao readings;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(String updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public ReadingsDao getReadings() {
        return readings;
    }

    public void setReadings(ReadingsDao readings) {
        this.readings = readings;
    }

    public static class ReadingsDao {

        @SerializedName("o3_sub_index") private ReadingDao o3SubIndex;
        @SerializedName("pm10_twenty_four_hourly") private ReadingDao pm10TwentyFourHourly;
        @SerializedName("co_sub_index") private ReadingDao coSubIndex;
        @SerializedName("pm10_sub_index") private ReadingDao pm10SubIndex;
        @SerializedName("pm25_twenty_four_hourly") private ReadingDao pm25TwentyFourHourly;
        @SerializedName("so2_sub_index") private ReadingDao so2SubIndex;
        @SerializedName("co_eight_hour_max") private ReadingDao coEightHourMax;
        @SerializedName("so2_twenty_four_hourly") private ReadingDao so2TwentyFourHourly;
        @SerializedName("no2_one_hour_max") private ReadingDao no2OneHourMax;
        @SerializedName("pm25_sub_index") private ReadingDao pm25SubIndex;
        @SerializedName("psi_twenty_four_hourly") private ReadingDao psiTwentyFourHourly;
        @SerializedName("o3_eight_hour_max") private ReadingDao o3EightHourMax;
        @SerializedName("psi_three_hourly") private ReadingDao psiThreeHourly;

        public ReadingDao getO3SubIndex() {
            return o3SubIndex;
        }

        public void setO3SubIndex(ReadingDao o3SubIndex) {
            this.o3SubIndex = o3SubIndex;
        }

        public ReadingDao getPm10TwentyFourHourly() {
            return pm10TwentyFourHourly;
        }

        public void setPm10TwentyFourHourly(ReadingDao pm10TwentyFourHourly) {
            this.pm10TwentyFourHourly = pm10TwentyFourHourly;
        }

        public ReadingDao getCoSubIndex() {
            return coSubIndex;
        }

        public void setCoSubIndex(ReadingDao coSubIndex) {
            this.coSubIndex = coSubIndex;
        }

        public ReadingDao getPm10SubIndex() {
            return pm10SubIndex;
        }

        public void setPm10SubIndex(ReadingDao pm10SubIndex) {
            this.pm10SubIndex = pm10SubIndex;
        }

        public ReadingDao getPm25TwentyFourHourly() {
            return pm25TwentyFourHourly;
        }

        public void setPm25TwentyFourHourly(ReadingDao pm25TwentyFourHourly) {
            this.pm25TwentyFourHourly = pm25TwentyFourHourly;
        }

        public ReadingDao getSo2SubIndex() {
            return so2SubIndex;
        }

        public void setSo2SubIndex(ReadingDao so2SubIndex) {
            this.so2SubIndex = so2SubIndex;
        }

        public ReadingDao getCoEightHourMax() {
            return coEightHourMax;
        }

        public void setCoEightHourMax(ReadingDao coEightHourMax) {
            this.coEightHourMax = coEightHourMax;
        }

        public ReadingDao getSo2TwentyFourHourly() {
            return so2TwentyFourHourly;
        }

        public void setSo2TwentyFourHourly(ReadingDao so2TwentyFourHourly) {
            this.so2TwentyFourHourly = so2TwentyFourHourly;
        }

        public ReadingDao getNo2OneHourMax() {
            return no2OneHourMax;
        }

        public void setNo2OneHourMax(ReadingDao no2OneHourMax) {
            this.no2OneHourMax = no2OneHourMax;
        }

        public ReadingDao getPm25SubIndex() {
            return pm25SubIndex;
        }

        public void setPm25SubIndex(ReadingDao pm25SubIndex) {
            this.pm25SubIndex = pm25SubIndex;
        }

        public ReadingDao getPsiTwentyFourHourly() {
            return psiTwentyFourHourly;
        }

        public void setPsiTwentyFourHourly(ReadingDao psiTwentyFourHourly) {
            this.psiTwentyFourHourly = psiTwentyFourHourly;
        }

        public ReadingDao getO3EightHourMax() {
            return o3EightHourMax;
        }

        public void setO3EightHourMax(ReadingDao o3EightHourMax) {
            this.o3EightHourMax = o3EightHourMax;
        }

        public ReadingDao getPsiThreeHourly() {
            return psiThreeHourly;
        }

        public void setPsiThreeHourly(ReadingDao psiThreeHourly) {
            this.psiThreeHourly = psiThreeHourly;
        }
    }
}