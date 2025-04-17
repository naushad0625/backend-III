package _02_DynamicPricingEngineForFinance.pricingStrategy;

import _02_DynamicPricingEngineForFinance.derivative.Derivative;
import _02_DynamicPricingEngineForFinance.marketData.MarketData;

public class SwapPricingStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(Derivative derivative, MarketData marketData) {
        return 0;
    }
}
