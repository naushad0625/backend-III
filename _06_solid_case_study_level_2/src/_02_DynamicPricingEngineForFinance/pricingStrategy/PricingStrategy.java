package _02_DynamicPricingEngineForFinance.pricingStrategy;

import _02_DynamicPricingEngineForFinance.derivative.Derivative;
import _02_DynamicPricingEngineForFinance.marketData.MarketData;

public interface PricingStrategy {
    public double calculatePrice(Derivative derivative, MarketData marketData);
}
