package _02_DynamicPricingEngineForFinance.catching;

import _02_DynamicPricingEngineForFinance.derivative.Derivative;

import java.util.Optional;

public class FutureCache implements Cacheable {
    @Override
    public void cache(Derivative derivative) {

    }

    @Override
    public Optional<Derivative> getCache(String key) {
        return Optional.empty();
    }

    // other methods
}
