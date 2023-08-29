package com.example.carrental.nbpconfig;


import com.example.carrental.domain.euro.DolarRate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class NbpClient {

    private final NbpConfig nbpConfig;
    private final RestTemplate restTemplate;

    public URI getUrl() {

        return UriComponentsBuilder.fromHttpUrl(nbpConfig.getUsdRateEndpoint())
                .build()
                .encode()
                .toUri();
    }

    public DolarRate getDolarRate() {
        return restTemplate.getForObject(getUrl(), DolarRate.class);
    }
}