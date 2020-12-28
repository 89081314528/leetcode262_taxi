package ru.julia.taxi.taxi.dto;

public class Rate {
    Long data;
    Double rate;

    public Long getData() {
        return data;
    }

    public Double getRate() {
        return rate;
    }

    public Rate(Long data, Double rate) {
        this.data = data;
        this.rate = rate;
    }
}
