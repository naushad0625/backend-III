package _02_DynamicPricingEngineForFinance.catching;

import _02_DynamicPricingEngineForFinance.derivative.Derivative;

import java.util.Optional;

public class OptionCache implements Cacheable {
    @Override
    public void cache(Derivative derivative) {
        System.out.println("Option derivative Cached");
    }

    @Override
    public Optional<Derivative> getCache(String key) {
        System.out.println("Fetching Option Cache.");
        return Optional.of(new Derivative());
    }

    // other methods
}
