
package com.example.coronatracker.models.Details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryInfo {

    @SerializedName("_id")
    @Expose
    private Integer id;
    //    @SerializedName("iso2")
//    @Expose
//    private String iso2;
//    @SerializedName("iso3")
//    @Expose
//    private String iso3;
//    @SerializedName("lat")
//    @Expose
//    private Integer lat;
//    @SerializedName("long")
//    @Expose
//    private Integer _long;
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
//        this.iso2 = iso2;
//        this.iso3 = iso3;
//        this.lat = lat;
//        this._long = _long;
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public String getIso2() {
//        return iso2;
//    }
//
//    public void setIso2(String iso2) {
//        this.iso2 = iso2;
//    }
//
//    public String getIso3() {
//        return iso3;
//    }
//
//    public void setIso3(String iso3) {
//        this.iso3 = iso3;
//    }
//
//    public Integer getLat() {
//        return lat;
//    }
//
//    public void setLat(Integer lat) {
//        this.lat = lat;
//    }
//
//    public Integer getLong() {
//        return _long;
//    }
//
//    public void setLong(Integer _long) {
//        this._long = _long;
//    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

}
