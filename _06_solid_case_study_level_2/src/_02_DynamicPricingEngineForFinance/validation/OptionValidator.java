package _02_DynamicPricingEngineForFinance.validation;

import _02_DynamicPricingEngineForFinance.derivative.Derivative;
import _02_DynamicPricingEngineForFinance.pricingStrategy.PricingStrategy;

import java.util.concurrent.CompletableFuture;

public class OptionValidator implements PricingStartegyValidator{
    @Override
    public CompletableFuture<Boolean> validate(Derivative derivative) {
        System.out.println("Validating Option Strategy");

        // Validation logic

        return CompletableFuture.supplyAsync(()->true);
    }
}
