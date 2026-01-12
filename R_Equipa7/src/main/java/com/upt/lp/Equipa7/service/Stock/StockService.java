package com.upt.lp.Equipa7.service.Stock;

import org.springframework.stereotype.Service;
import com.upt.Equipa7.Config.StockClient;
import com.upt.lp.Equipa7.DTO.Stock.StockPriceDTO;

@Service
public class StockService {

    private final StockClient stockClient;

    public StockService(StockClient stockClient) {
        this.stockClient = stockClient;
    }

    public StockPriceDTO getStockPrice(String symbol) {
        return stockClient.getCurrentPrice(symbol);
    }
}