package com.example.carrental.facade;


import com.example.carrental.domain.euro.DolarRate;
import com.example.carrental.nbpconfig.NbpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NbpFacade {

    private final NbpClient nbpClient;

    public Double getDolarRate() {
        DolarRate euroRate = nbpClient.getDolarRate();
        return euroRate.rates[0].getMid();
    }
}