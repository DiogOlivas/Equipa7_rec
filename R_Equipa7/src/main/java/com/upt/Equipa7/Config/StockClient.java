package com.upt.Equipa7.Config;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.upt.lp.Equipa7.DTO.Stock.AlphaVantageQuoteResponse;
import com.upt.lp.Equipa7.DTO.Stock.StockPriceDTO;

import reactor.core.publisher.Mono;

@Component
public class StockClient {

    private final WebClient webClient;
    private final String apiKey;

    public StockClient(
            WebClient.Builder builder,
            @Value("${alphavantage.base-url}") String baseUrl,
            @Value("${alphavantage.api-key}") String apiKey
    ) {
        this.apiKey = apiKey;
        this.webClient = builder
                .baseUrl(baseUrl)
                .build();
    }

    public Mono<StockPriceDTO> getCurrentPrice(String symbol) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/query")
                        .queryParam("function", "GLOBAL_QUOTE")
                        .queryParam("symbol", symbol)
                        .queryParam("apikey", apiKey)
                        .build()
                )
                .retrieve()
                .onStatus(HttpStatusCode::isError, response ->
                        response.bodyToMono(String.class)
                                .map(body ->
                                        new RuntimeException("Alpha Vantage HTTP error: " + body)))
                .bodyToMono(AlphaVantageQuoteResponse.class)
                .flatMap(response -> {
                    if (response == null || response.getGlobalQuote() == null) {
                        return Mono.error(
                                new RuntimeException("Invalid Alpha Vantage response (possible rate limit or invalid symbol)"));
                    }

                    return Mono.just(
                            new StockPriceDTO(
                                    response.getGlobalQuote().getSymbol(),
                                    response.getGlobalQuote().getPrice(),
                                    LocalDateTime.now()
                            )
                    );
                }
                );
    }
}
