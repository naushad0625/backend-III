package _02_DynamicPricingEngineForFinance.pricingStrategy;

import _02_DynamicPricingEngineForFinance.catching.Cacheable;
import _02_DynamicPricingEngineForFinance.marketData.MarketDataAdapter;
import _02_DynamicPricingEngineForFinance.validation.PricingStartegyValidator;

import java.util.concurrent.ExecutionException;

public class PriceCalculationManager {
    private PricingStrategy pricingStrategy;
    private MarketDataAdapter marketDataAdapter;
    private PricingStartegyValidator validator;
    private Cacheable cacheStrategy;

    public PriceCalculationManager(PricingStrategy pricingStrategy, MarketDataAdapter adapter, PricingStartegyValidator validator, Cacheable cacheStrategy) {
        this.pricingStrategy = pricingStrategy;
        this.marketDataAdapter = adapter;
        this.validator = validator;
        this.cacheStrategy = cacheStrategy;
    }

//    public double calculatePrice() {
//
//        return cacheStrategy.get(pricingStrategy).orElseGet(() -> {
//            try {
////                return validator.validate(pricingStrategy)
////                        .thenCompose(valid -> marketDataAdapter.fetchMarketData())
////                        .thenApply(marketData -> pricingStrategy.calculatePrice(marketData)).get();
//            } catch (InterruptedException | ExecutionException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//    }
}
