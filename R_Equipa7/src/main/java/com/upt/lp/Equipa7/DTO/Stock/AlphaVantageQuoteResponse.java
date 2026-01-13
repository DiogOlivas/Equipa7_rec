package com.upt.lp.Equipa7.DTO.Stock;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlphaVantageQuoteResponse {
	 @JsonProperty("Global Quote")
	    private GlobalQuote globalQuote;

	    public static class GlobalQuote {

	        @JsonProperty("01. symbol")
	        private String symbol;

	        @JsonProperty("05. price")
	        private BigDecimal price;

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
	        
	    }

		public GlobalQuote getGlobalQuote() {
			return globalQuote;
		}

		public void setGlobalQuote(GlobalQuote globalQuote) {
			this.globalQuote = globalQuote;
		}
}
