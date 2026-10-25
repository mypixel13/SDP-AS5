package housebuilder.foundation;


public record FoundationPlan(String foundationType, double concreteCubicMeters, int durationDays, double costUsd) {

    @Override
    public String toString() {
        return String.format("%-14s | concrete: %6.1f m3 | duration: %2d days | cost: $%,10.2f",
                foundationType, concreteCubicMeters, durationDays, costUsd);
    }
}
