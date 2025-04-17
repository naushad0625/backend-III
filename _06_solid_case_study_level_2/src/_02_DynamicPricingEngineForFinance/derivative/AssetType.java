package _02_DynamicPricingEngineForFinance.derivative;

public enum AssetType {
    OPTION("option"), SWAP("swap"), FUTURE("future");
    private final String value;

    AssetType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
