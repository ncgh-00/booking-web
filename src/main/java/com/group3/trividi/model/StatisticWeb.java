package com.group3.trividi.model;

public class StatisticWeb {
    private int numberBooks;
    private double total;

    public int getNumberBooks() {
        return numberBooks;
    }

    public void setNumberBooks(int numberBooks) {
        this.numberBooks = numberBooks;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public StatisticWeb(int numberBooks, double total) {
        this.numberBooks = numberBooks;
        this.total = total;
    }

    @Override
    public String toString() {
        return "StatisticWeb{" +
                "numberBooks=" + numberBooks +
                ", total=" + total +
                '}';
    }
}
