
package com.example.coronatracker.models.cases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CasesModelResponse {

    @SerializedName("confirmed")
    @Expose
    private Confirmed confirmed;
    @SerializedName("recovered")
    @Expose
    private Recovered recovered;
    @SerializedName("deaths")
    @Expose
    private Deaths deaths;
    @SerializedName("dailySummary")
    @Expose
    private String dailySummary;
    @SerializedName("dailyTimeSeries")
    @Expose
    private DailyTimeSeries dailyTimeSeries;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("countries")
    @Expose
    private String countries;
    @SerializedName("countryDetail")
    @Expose
    private CountryDetail countryDetail;
    @SerializedName("lastUpdate")
    @Expose
    private String lastUpdate;

    /**
     * No args constructor for use in serialization
     */
    public CasesModelResponse() {
    }

    /**
     * @param dailyTimeSeries
     * @param image
     * @param recovered
     * @param dailySummary
     * @param lastUpdate
     * @param countryDetail
     * @param source
     * @param countries
     * @param confirmed
     * @param deaths
     */
    public CasesModelResponse(Confirmed confirmed, Recovered recovered, Deaths deaths, String dailySummary, DailyTimeSeries dailyTimeSeries, String image, String source, String countries, CountryDetail countryDetail, String lastUpdate) {
        super();
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
        this.dailySummary = dailySummary;
        this.dailyTimeSeries = dailyTimeSeries;
        this.image = image;
        this.source = source;
        this.countries = countries;
        this.countryDetail = countryDetail;
        this.lastUpdate = lastUpdate;
    }

    public Confirmed getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Confirmed confirmed) {
        this.confirmed = confirmed;
    }

    public Recovered getRecovered() {
        return recovered;
    }

    public void setRecovered(Recovered recovered) {
        this.recovered = recovered;
    }

    public Deaths getDeaths() {
        return deaths;
    }

    public void setDeaths(Deaths deaths) {
        this.deaths = deaths;
    }

    public String getDailySummary() {
        return dailySummary;
    }

    public void setDailySummary(String dailySummary) {
        this.dailySummary = dailySummary;
    }

    public DailyTimeSeries getDailyTimeSeries() {
        return dailyTimeSeries;
    }

    public void setDailyTimeSeries(DailyTimeSeries dailyTimeSeries) {
        this.dailyTimeSeries = dailyTimeSeries;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public CountryDetail getCountryDetail() {
        return countryDetail;
    }

    public void setCountryDetail(CountryDetail countryDetail) {
        this.countryDetail = countryDetail;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
