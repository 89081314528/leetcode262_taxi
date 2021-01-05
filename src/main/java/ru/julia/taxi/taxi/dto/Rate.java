package ru.julia.taxi.taxi.dto;

public class Rate {
    final Long date;
    final Double rate;

    public Long getDate() {
        return date;
    }

    public Double getRate() {
        return rate;
    }

    public Rate(Long date, Double rate) {
        this.date = date;
        this.rate = rate;
    }
}
