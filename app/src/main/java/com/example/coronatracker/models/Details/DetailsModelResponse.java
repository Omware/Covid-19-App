
package com.example.coronatracker.models.Details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailsModelResponse {

    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("countryInfo")
    @Expose
    private CountryInfo countryInfo;
    @SerializedName("cases")
    @Expose
    private Integer cases;
    @SerializedName("todayCases")
    @Expose
    private Integer todayCases;
    @SerializedName("deaths")
    @Expose
    private Integer deaths;
    @SerializedName("todayDeaths")
    @Expose
    private Integer todayDeaths;
    @SerializedName("recovered")
    @Expose
    private Integer recovered;
    @SerializedName("active")
    @Expose
    private Integer active;
    @SerializedName("critical")
    @Expose
    private Integer critical;
    //    @SerializedName("casesPerOneMillion")
//    @Expose
//    private Integer casesPerOneMillion;
//    @SerializedName("deathsPerOneMillion")
//    @Expose
//    private Integer deathsPerOneMillion;
    @SerializedName("updated")
    @Expose
    private Long updated;

    /**
     * No args constructor for use in serialization
     */
    public DetailsModelResponse() {
    }

    /**
     * @param country
     * @param recovered
     * @param cases
     * @param critical
     * @param deathsPerOneMillion
     * @param active
     * @param casesPerOneMillion
     * @param countryInfo
     * @param updated
     * @param deaths
     * @param todayCases
     * @param todayDeaths
     */
    public DetailsModelResponse(String country, CountryInfo countryInfo, Integer cases, Integer todayCases, Integer deaths, Integer todayDeaths, Integer recovered, Integer active, Integer critical, Integer casesPerOneMillion, Integer deathsPerOneMillion, Long updated) {
        super();
        this.country = country;
        this.countryInfo = countryInfo;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
//        this.casesPerOneMillion = casesPerOneMillion;
//        this.deathsPerOneMillion = deathsPerOneMillion;
        this.updated = updated;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CountryInfo getCountryInfo() {
        return countryInfo;
    }

    public void setCountryInfo(CountryInfo countryInfo) {
        this.countryInfo = countryInfo;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Integer getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(Integer todayCases) {
        this.todayCases = todayCases;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(Integer todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getCritical() {
        return critical;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }

//    public Integer getCasesPerOneMillion() {
//        return casesPerOneMillion;
//    }
//
//    public void setCasesPerOneMillion(Integer casesPerOneMillion) {
//        this.casesPerOneMillion = casesPerOneMillion;
//    }

//    public Integer getDeathsPerOneMillion() {
//        return deathsPerOneMillion;
//    }
//
//    public void setDeathsPerOneMillion(Integer deathsPerOneMillion) {
//        this.deathsPerOneMillion = deathsPerOneMillion;
//    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

}
