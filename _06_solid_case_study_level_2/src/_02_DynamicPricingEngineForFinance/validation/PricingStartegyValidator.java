package _02_DynamicPricingEngineForFinance.validation;

import _02_DynamicPricingEngineForFinance.derivative.Derivative;
import _02_DynamicPricingEngineForFinance.pricingStrategy.PricingStrategy;

import java.util.concurrent.CompletableFuture;

public interface PricingStartegyValidator {
    public CompletableFuture<Boolean> validate (Derivative derivative);
}
