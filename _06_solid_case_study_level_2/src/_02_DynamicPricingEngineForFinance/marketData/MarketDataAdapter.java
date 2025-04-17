package _02_DynamicPricingEngineForFinance.marketData;

import _02_DynamicPricingEngineForFinance.derivative.Derivative;

import java.util.concurrent.CompletableFuture;

public interface MarketDataAdapter {
    CompletableFuture<MarketData> fetchMarketData(Derivative derivative);
}
