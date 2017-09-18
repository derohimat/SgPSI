package net.derohimat.sgpsi.data.models;

import com.google.gson.annotations.SerializedName;

public class RegionMetadataDao {
    @SerializedName("name") private String name;
    @SerializedName("label_location") private LabelLocationDao labelLocation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LabelLocationDao getLabelLocation() {
        return labelLocation;
    }

    public void setLabelLocation(LabelLocationDao labelLocation) {
        this.labelLocation = labelLocation;
    }

    public static class LabelLocationDao {
        /**
         * longitude : 0
         * latitude : 0
         */

        @SerializedName("longitude") private double longitude;
        @SerializedName("latitude") private double latitude;

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }
    }
}