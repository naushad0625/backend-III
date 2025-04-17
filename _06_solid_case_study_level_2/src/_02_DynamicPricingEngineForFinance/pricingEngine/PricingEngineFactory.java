package _02_DynamicPricingEngineForFinance.pricingEngine;

import _02_DynamicPricingEngineForFinance.audit.Auditable;
import _02_DynamicPricingEngineForFinance.audit.OptionAudit;
import _02_DynamicPricingEngineForFinance.catching.Cacheable;
import _02_DynamicPricingEngineForFinance.catching.OptionCache;
import _02_DynamicPricingEngineForFinance.derivative.Derivative;
import _02_DynamicPricingEngineForFinance.marketData.MarketDataAdapter;
import _02_DynamicPricingEngineForFinance.marketData.OptionMarketDataAdapter;
import _02_DynamicPricingEngineForFinance.pricingStrategy.OptionPricingStrategy;
import _02_DynamicPricingEngineForFinance.pricingStrategy.PricingStrategy;
import _02_DynamicPricingEngineForFinance.validation.OptionValidator;
import _02_DynamicPricingEngineForFinance.validation.PricingStartegyValidator;

public class PricingEngineFactory {
    public static IPricingEngine create(String assetType) {

        if(assetType.equals("option")) {
            PricingStrategy pricingStrategy = new OptionPricingStrategy();
            Cacheable cacheable = new OptionCache();
            Derivative derivative = new Derivative();
            MarketDataAdapter marketDataAdapter = new OptionMarketDataAdapter();
            PricingStartegyValidator validator = new OptionValidator();
            Auditable auditable = new OptionAudit();

            return new OptionPricingEngine(pricingStrategy, cacheable, derivative,marketDataAdapter, validator, auditable);
        } else if (assetType.equals("future")) {
            //logic for Future
            return null;
        } else if (assetType.equals("swap")) {
            //logic for Swap
            return null;
        } else {
            // Error handle logic.
            return null;
        }

    }
}
