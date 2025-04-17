package _02_DynamicPricingEngineForFinance.audit;

import _02_DynamicPricingEngineForFinance.derivative.Derivative;

public interface Auditable {
    public boolean audit(Derivative derivative);
}
