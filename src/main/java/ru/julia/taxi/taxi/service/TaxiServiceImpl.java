package ru.julia.taxi.taxi.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.julia.taxi.taxi.dto.Rate;
import ru.julia.taxi.taxi.entity.Taxi;
import ru.julia.taxi.taxi.repozitories.TaxiRepository;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.get;
import static javax.swing.UIManager.getInt;

@Service
public class TaxiServiceImpl implements TaxiService {
    private final TaxiRepository taxiRepository;

    public TaxiServiceImpl(TaxiRepository taxiRepository) {
        this.taxiRepository = taxiRepository;
    }

    public List<Rate> getRates() {
        List<Taxi> taxiList = taxiRepository.findAll(Sort.by(Sort.Direction.ASC, "date"));
        List<Rate> rateList = new ArrayList<>();
        Long currentData = taxiList.get(0).getDate();
        int numberCancelled = 0;
        int numberAll = 0;
        for (int i = 0; i < taxiList.size(); i++) {
            Taxi taxi = taxiList.get(i);
            if (!taxi.getBanned().equals("no")) {
                continue;
            }
            if (taxi.getDate().equals(currentData) && (i != taxiList.size() - 1)) {
                if (taxi.getStatus().equals("cancelled")) {
                    numberCancelled = numberCancelled + 1;
                }
                numberAll = numberAll + 1;
            } else if (taxi.getDate().equals(currentData) && (i == taxiList.size() - 1)) {
                if (taxi.getStatus().equals("cancelled")) {
                    numberCancelled = numberCancelled + 1;
                }
                numberAll = numberAll + 1;
                rateList.add(new Rate(currentData, (double) numberCancelled / numberAll));
            } else {
                rateList.add(new Rate(currentData, (double) numberCancelled / numberAll));
                currentData = taxi.getDate();
                if (taxi.getStatus().equals("cancelled")) {
                    numberCancelled = 1;
                } else {
                    numberCancelled = 0;
                }
                numberAll = 1;
            }
        }

        return rateList;
    }
}
