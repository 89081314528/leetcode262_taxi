package ru.julia.taxi.taxi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taxi")
public class Taxi {
    @Column (name = "taxi_id") // я правильно назвала столбец? или надо было так назвать поле?
    @Id
    Long id;
    @Column
    String status;
    @Column
    Long Data;
    @Column
    String banned;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getData() {
        return Data;
    }

    public void setData(Long data) {
        Data = data;
    }

    public String getBanned() {
        return banned;
    }

    public void setBanned(String banned) {
        this.banned = banned;
    }

    public Taxi() {
    }

    public Taxi(Long id, String status, Long data, String banned) {
        this.id = id;
        this.status = status;
        Data = data;
        this.banned = banned;
    }
}
