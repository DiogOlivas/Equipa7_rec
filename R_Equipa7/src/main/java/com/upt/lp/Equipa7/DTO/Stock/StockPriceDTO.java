package com.upt.lp.Equipa7.DTO.Stock;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StockPriceDTO {
    private String symbol;
    private BigDecimal price;
    private LocalDateTime timestamp;
    
    public StockPriceDTO() {};
    
	public StockPriceDTO(String symbol, BigDecimal price, LocalDateTime timestamp) {
		super();
		this.symbol = symbol;
		this.price = price;
		this.timestamp = timestamp;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
}
