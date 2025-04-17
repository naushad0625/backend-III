package _02_DynamicPricingEngineForFinance.pricingEngine;

import _02_DynamicPricingEngineForFinance.derivative.Derivative;
import _02_DynamicPricingEngineForFinance.marketData.MarketData;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface IPricingEngine {
    public void calculatePrice(MarketData marketData);
    public CompletableFuture<MarketData> fetchMarketData();
    public void performAudit();
    public CompletableFuture<Boolean> performValidation();
    public void writeToCache();
    public Optional<Derivative> readFromCache(String key);
}
