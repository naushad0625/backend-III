package _02_DynamicPricingEngineForFinance.audit;

import _02_DynamicPricingEngineForFinance.derivative.Derivative;

public class OptionAudit implements Auditable{
    @Override
    public boolean audit(Derivative derivative) {
        return false;
    }
}
