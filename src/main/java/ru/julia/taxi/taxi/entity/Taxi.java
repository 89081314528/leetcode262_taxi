package ru.julia.taxi.taxi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taxies")// таблица - во множ, сущность в единственном
public class Taxi {
    @Column(name = "taxi_id") // в един числе
    @Id
    Long id;
    // обычно указывают название колонок в таблице, даже если они совпадают с названиями полей
    @Column(name = "status")
    String status;
    @Column(name = "date")
    Long date;
    @Column(name = "banned")
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

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
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
        this.date = data;
        this.banned = banned;
    }
}
