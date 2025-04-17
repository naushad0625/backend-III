package _02_DynamicPricingEngineForFinance.pricingEngine;

import _02_DynamicPricingEngineForFinance.audit.Auditable;
import _02_DynamicPricingEngineForFinance.catching.Cacheable;
import _02_DynamicPricingEngineForFinance.derivative.Derivative;
import _02_DynamicPricingEngineForFinance.marketData.MarketData;
import _02_DynamicPricingEngineForFinance.marketData.MarketDataAdapter;
import _02_DynamicPricingEngineForFinance.pricingStrategy.PricingStrategy;
import _02_DynamicPricingEngineForFinance.validation.PricingStartegyValidator;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class OptionPricingEngine implements IPricingEngine {

    private PricingStrategy pricingStrategy;
    private Cacheable cacheable;
    private Derivative derivative;
    private MarketDataAdapter marketDataAdapter;
    private PricingStartegyValidator validator;
    private Auditable auditable;

    public OptionPricingEngine(PricingStrategy pricingStrategy, Cacheable cacheable, Derivative derivative, MarketDataAdapter marketDataAdapter, PricingStartegyValidator validator, Auditable auditable) {
        this.pricingStrategy = pricingStrategy;
        this.cacheable = cacheable;
        this.derivative = derivative;
        this.marketDataAdapter = marketDataAdapter;
        this.validator = validator;
        this.auditable = auditable;
    }

    @Override
    public void calculatePrice(MarketData marketData) {
        pricingStrategy.calculatePrice(derivative, marketData);
    }

    @Override
    public CompletableFuture<MarketData> fetchMarketData() {
        return marketDataAdapter.fetchMarketData(derivative);
    }

    @Override
    public void performAudit() {
        auditable.audit(derivative);
    }

    @Override
    public CompletableFuture<Boolean> performValidation() {
        return validator.validate(derivative);
    }

    @Override
    public void writeToCache() {
        cacheable.cache(derivative);
    }

    @Override
    public Optional<Derivative> readFromCache(String key) {
        return cacheable.getCache(key);
    }
}
