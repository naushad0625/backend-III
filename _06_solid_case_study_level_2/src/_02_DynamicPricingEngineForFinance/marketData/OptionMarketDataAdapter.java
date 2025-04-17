package _02_DynamicPricingEngineForFinance.marketData;

import _02_DynamicPricingEngineForFinance.derivative.Derivative;

import java.util.concurrent.CompletableFuture;

public class OptionMarketDataAdapter implements MarketDataAdapter{
    @Override
    public CompletableFuture<MarketData> fetchMarketData(Derivative derivative) {
        return null;
    }
}
