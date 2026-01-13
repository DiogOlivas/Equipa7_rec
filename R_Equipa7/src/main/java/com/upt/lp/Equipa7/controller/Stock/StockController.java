package com.upt.lp.Equipa7.controller.Stock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upt.lp.Equipa7.DTO.Stock.StockPriceDTO;
import com.upt.lp.Equipa7.service.Stock.StockService;

import jakarta.validation.constraints.NotBlank;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{symbol}")
    public Mono<StockPriceDTO> getStock(@PathVariable @NotBlank String symbol) {
        return stockService.getStockPrice(symbol);
    }
}