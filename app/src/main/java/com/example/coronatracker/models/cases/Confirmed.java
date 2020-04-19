
package com.example.coronatracker.models.cases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Confirmed {

    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("detail")
    @Expose
    private String detail;

    /**
     * No args constructor for use in serialization
     */
    public Confirmed() {
    }

    /**
     * @param detail
     * @param value
     */
    public Confirmed(Integer value, String detail) {
        super();
        this.value = value;
        this.detail = detail;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
