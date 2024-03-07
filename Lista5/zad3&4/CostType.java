public enum CostType {
    REFUELING("Tankowanie"),
    SERVICE("Serwis"),
    PARKING("Parking"),
    INSURANCE("Ubezpieczenie"),
    TICKET("Mandat"),
    TOTAL("Suma wydatków");

    private final String costType;

    CostType(String costType) {
        this.costType = costType;
    }

    public String getCostType() {
        return costType;
    }
}