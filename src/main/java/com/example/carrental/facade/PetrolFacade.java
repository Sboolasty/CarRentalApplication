package com.example.carrental.facade;


import com.example.carrental.domain.*;
import com.example.carrental.domain.petrol.Petrol;
import com.example.carrental.petrolconfig.PetrolClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PetrolFacade {

    private final PetrolClient petrolClient;
    private final NbpFacade nbpFacade;

    public Double getPetrolPriceDolarPerGalon() {
        Petrol petrol = petrolClient.getPetrolPrices();
        return (double) petrol.series.get(0).data[0][1];
    }

    public Double countPetrolPricePerOneLitre() {
        double litresInGalon = 3.78;
        return (getPetrolPriceDolarPerGalon() * nbpFacade.getDolarRate())/litresInGalon;
    }
}