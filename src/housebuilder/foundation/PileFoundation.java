package housebuilder.foundation;


public class PileFoundation implements FoundationStrategy {

    private static final double PILE_SPACING_METERS = 2.0;
    private static final double PILE_RADIUS_METERS = 0.15;
    private static final double PILE_LENGTH_METERS = 4.0;
    private static final double GRILLAGE_CROSS_SECTION_SQUARE_METERS = 0.3 * 0.4;
    private static final double COST_PER_CUBIC_METER_USD = 320;
    private static final int PILES_PER_DAY = 6;
    private static final int CONCRETE_CURING_DAYS = 7;

    @Override
    public String name() {
        return "Pile";
    }

    @Override
    public FoundationPlan plan(HouseSpec house) {
        int pileCount = (int) Math.ceil(house.perimeterMeters() / PILE_SPACING_METERS);
        double pilesConcrete = pileCount * Math.PI * PILE_RADIUS_METERS * PILE_RADIUS_METERS * PILE_LENGTH_METERS;
        double grillageConcrete = house.perimeterMeters() * GRILLAGE_CROSS_SECTION_SQUARE_METERS;
        double concrete = pilesConcrete + grillageConcrete;
        int days = (int) Math.ceil((double) pileCount / PILES_PER_DAY) + CONCRETE_CURING_DAYS;
        return new FoundationPlan(name(), concrete, days, concrete * COST_PER_CUBIC_METER_USD);
    }
}
