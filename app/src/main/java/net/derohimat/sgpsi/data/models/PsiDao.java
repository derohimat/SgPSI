package net.derohimat.sgpsi.data.models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PsiDao extends RealmObject {

    @PrimaryKey private long id;
    @SerializedName("api_info") private ApiInfoDao apiInfo;
    @SerializedName("items") private RealmList<ItemsDao> items;

    public long getId() {
        return id;
    }

    public ApiInfoDao getApiInfo() {
        return apiInfo;
    }

    public RealmList<ItemsDao> getItems() {
        return items;
    }
}