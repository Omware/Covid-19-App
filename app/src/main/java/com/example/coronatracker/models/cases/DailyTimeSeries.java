
package com.example.coronatracker.models.cases;

import com.google.gson.annotations.*;

public class DailyTimeSeries {

    @SerializedName("pattern")
    @Expose
    private String pattern;
    @SerializedName("example")
    @Expose
    private String example;

    /**
     * No args constructor for use in serialization
     */
    public DailyTimeSeries() {
    }

    /**
     * @param pattern
     * @param example
     */
    public DailyTimeSeries(String pattern, String example) {
        super();
        this.pattern = pattern;
        this.example = example;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

}
