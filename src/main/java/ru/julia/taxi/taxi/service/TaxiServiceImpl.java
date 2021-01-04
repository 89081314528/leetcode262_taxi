package ru.julia.taxi.taxi.service;

import org.springframework.stereotype.Service;
import ru.julia.taxi.taxi.dto.Rate;
import ru.julia.taxi.taxi.entity.Taxi;
import ru.julia.taxi.taxi.repozitories.TaxiRepository;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.get;

@Service
public class TaxiServiceImpl implements TaxiService {
    private final TaxiRepository taxiRepository;

    public TaxiServiceImpl(TaxiRepository taxiRepository) {
        this.taxiRepository = taxiRepository;
    }

    public List<Rate> rate() {
        List<Taxi> taxiList = taxiRepository.findAll();
        List<Rate> rateList = new ArrayList<>();
        Long currentData = taxiList.get(0).getData();
        Double numberCancelled = 0.00;
        Double numberAll = 0.00;
        for (int i = 0; i < taxiList.size(); i++) {
            Taxi taxi = taxiList.get(i);
            if (taxi.getBanned().equals("no")) {
                if (taxi.getData().equals(currentData) && (i != taxiList.size() - 1)){
                    if (taxi.getStatus().equals("cancelled")) {
                        numberCancelled = numberCancelled + 1.00;
                    }
                    numberAll = numberAll + 1;
                } else
                if (taxi.getData().equals(currentData) && (i == taxiList.size() - 1)){
                    if (taxi.getStatus().equals("cancelled")) {
                        numberCancelled = numberCancelled + 1.00;
                    }
                    numberAll = numberAll + 1;
                    rateList.add(new Rate (currentData, numberCancelled/numberAll));
                } else {
                    rateList.add(new Rate (currentData, numberCancelled/numberAll));
                    currentData = taxi.getData();
                    if (taxi.getStatus().equals("cancelled")) {
                        numberCancelled = 1.00;
                    } else {
                        numberCancelled = 0.00;
                    }
                    numberAll = 1.00;
                }
            }
        }
        return rateList;
    }
}
