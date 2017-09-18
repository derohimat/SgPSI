package net.derohimat.sgpsi.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PsiDao {

    @SerializedName("api_info") private ApiInfoDao apiInfo;
    @SerializedName("region_metadata") private List<RegionMetadataDao> regionMetadata;
    @SerializedName("items") private List<ItemsDao> items;

    public ApiInfoDao getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(ApiInfoDao apiInfo) {
        this.apiInfo = apiInfo;
    }

    public List<RegionMetadataDao> getRegionMetadata() {
        return regionMetadata;
    }

    public void setRegionMetadata(List<RegionMetadataDao> regionMetadata) {
        this.regionMetadata = regionMetadata;
    }

    public List<ItemsDao> getItems() {
        return items;
    }

    public void setItems(List<ItemsDao> items) {
        this.items = items;
    }
}