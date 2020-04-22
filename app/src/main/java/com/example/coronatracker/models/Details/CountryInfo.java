
package com.example.coronatracker.models.Details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryInfo {

    @SerializedName("_id")
    @Expose
    private Integer id;
    @SerializedName("flag")
    @Expose
    private String flag;

    /**
     * No args constructor for use in serialization
     */
    public CountryInfo() {
    }

    /**
     * @param flag
     * @param _long
     * @param id
     * @param iso2
     * @param lat
     * @param iso3
     */
    public CountryInfo(Integer id, String iso2, String iso3, Integer lat, Integer _long, String flag) {
        super();
        this.id = id;
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

}
