package ru.julia.taxi.taxi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.julia.taxi.taxi.entity.Taxi;

public interface TaxiRepository extends JpaRepository<Taxi,Long> {
}
