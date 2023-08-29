package com.example.carrental.controller;


import com.example.carrental.facade.NbpFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/nbp")
@RequiredArgsConstructor
public class NbpController {

    private final NbpFacade nbpFacade;

    @GetMapping(value = "/dolar")
    public Double getDolarRate() {
        return nbpFacade.getDolarRate();
    }
}