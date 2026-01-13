package com.upt.lp.Equipa7.DTO.Stock;

import java.util.List;

public class StockHistoryDTO {
	 private String symbol;
	 private List<StockPriceDTO> prices;
	 
	 public StockHistoryDTO() {};
	 
	 public StockHistoryDTO(String symbol, List<StockPriceDTO> prices) {
		super();
		this.symbol = symbol;
		this.prices = prices;
	 }

	 public String getSymbol() {
		 return symbol;
	 }

	 public void setSymbol(String symbol) {
		 this.symbol = symbol;
	 }

	 public List<StockPriceDTO> getPrices() {
		 return prices;
	 }

	 public void setPrices(List<StockPriceDTO> prices) {
		 this.prices = prices;
	 }
}
