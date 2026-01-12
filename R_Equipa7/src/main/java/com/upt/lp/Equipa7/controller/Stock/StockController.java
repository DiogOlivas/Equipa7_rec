package com.upt.lp.Equipa7.controller.Stock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upt.lp.Equipa7.DTO.Stock.StockPriceDTO;
import com.upt.lp.Equipa7.service.Stock.StockService;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{symbol}")
    public StockPriceDTO getStock(@PathVariable String symbol) {
        return stockService.getStockPrice(symbol);
    }
}