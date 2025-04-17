package _02_DynamicPricingEngineForFinance;

import _02_DynamicPricingEngineForFinance.catching.Cacheable;
import _02_DynamicPricingEngineForFinance.catching.OptionCache;
import _02_DynamicPricingEngineForFinance.marketData.MarketData;
import _02_DynamicPricingEngineForFinance.marketData.MarketDataAdapter;
import _02_DynamicPricingEngineForFinance.pricingEngine.IPricingEngine;
import _02_DynamicPricingEngineForFinance.pricingEngine.PricingEngineFactory;
import _02_DynamicPricingEngineForFinance.pricingStrategy.OptionPricingStrategy;
import _02_DynamicPricingEngineForFinance.pricingStrategy.PriceCalculationManager;
import _02_DynamicPricingEngineForFinance.pricingStrategy.PricingStrategy;
import _02_DynamicPricingEngineForFinance.validation.OptionValidator;
import _02_DynamicPricingEngineForFinance.validation.PricingStartegyValidator;

import java.util.concurrent.CompletableFuture;

public class DynamicPricingEngine {
    public static void main(String[] args) {
        IPricingEngine pricingEngine = PricingEngineFactory.create("option");
        
    }
}
