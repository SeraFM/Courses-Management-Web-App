package com.classwebbeta.statistics;

public class Statistics {

    private double min;
    private double max;
    private double mean;
    private double standardDeviation;
    private double variance;
    private double percentiles;
    private double skewness;
    private double kurtosis;
    private double median;
    private int successRate;

    public Statistics(double min, double max, double mean, double standardDeviation, double variance,
            double percentiles, double skewness, double kurtosis, double median, int successRate) {
        this.min = min;
        this.max = max;
        this.mean = mean;
        this.standardDeviation = standardDeviation;
        this.variance = variance;
        this.percentiles = percentiles;
        this.skewness = skewness;
        this.kurtosis = kurtosis;
        this.median = median;
        this.successRate = successRate;
    }

    
    public int getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(int successRate) {
        this.successRate = successRate;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    public double getVariance() {
        return variance;
    }

    public void setVariance(double variance) {
        this.variance = variance;
    }

    public double getPercentiles() {
        return percentiles;
    }

    public void setPercentiles(double percentiles) {
        this.percentiles = percentiles;
    }

    public double getSkewness() {
        return skewness;
    }

    public void setSkewness(double skewness) {
        this.skewness = skewness;
    }

    public double getKurtosis() {
        return kurtosis;
    }

    public void setKurtosis(double kurtosis) {
        this.kurtosis = kurtosis;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

}
