package _02_DynamicPricingEngineForFinance.catching;

import _02_DynamicPricingEngineForFinance.derivative.Derivative;

import java.util.Optional;

public interface Cacheable {
    public void cache(Derivative derivative);
    public Optional<Derivative> getCache(String key);
}
