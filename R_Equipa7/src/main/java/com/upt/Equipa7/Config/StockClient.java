package com.upt.Equipa7.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.upt.lp.Equipa7.DTO.Stock.StockPriceDTO;

@Component
public class StockClient {

    private final WebClient webClient;

    public StockClient(
        WebClient.Builder builder,
        @Value("${https://www.alphavantage.co/}") String baseUrl,
        @Value("${55P404WDBW7OCMLE}") String apiKey
    ) {
        this.webClient = builder
            .baseUrl(baseUrl)
            .defaultHeader("X-API-KEY", apiKey)
            .build();
    }

    public StockPriceDTO getCurrentPrice(String symbol) {
        return webClient.get()
            .uri("/quote/{symbol}", symbol)
            .retrieve()
            .bodyToMono(StockPriceDTO.class)
            .block();
    }
}
