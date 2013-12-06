package com.pearson.hashmark.tests;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

public class Result {
    
    private final String description;
    private final SummaryStatistics timeStats;
    
    public Result(String description) {
        this.description = description;
        timeStats = new SummaryStatistics();
    }

    public void addTime(long time) {
        timeStats.addValue(time);
    }
    
    public String getDescription() {
        return description;
    }

    public double getMeanTime() {
        return timeStats.getMean();
    }
    
    public long getN() {
        return timeStats.getN();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("description", description)
                .append("meanTime", getMeanTime())
                .append("N", getN())
                .toString();
    }
    
}