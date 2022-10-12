package com.group3.trividi.model;

public class Statistic_Rate {
    private int numOfRates;
    private double numberOfStars;

    public Statistic_Rate(int numOfRates, double numberOfStars) {
        this.numOfRates = numOfRates;
        this.numberOfStars = numberOfStars;
    }

    public int getNumOfRates() {
        return numOfRates;
    }

    public void setNumOfRates(int numOfRates) {
        this.numOfRates = numOfRates;
    }

    public double getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(double numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    @Override
    public String toString() {
        return "Statistic_Rate{" +
                "numOfRates=" + numOfRates +
                ", numberOfStars=" + numberOfStars +
                '}';
    }
}
