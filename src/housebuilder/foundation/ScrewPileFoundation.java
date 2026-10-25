package housebuilder.foundation;


public class ScrewPileFoundation implements FoundationStrategy {

    private static final double PILE_SPACING_METERS = 2.5;
    private static final double COST_PER_PILE_USD = 140;
    private static final int PILES_PER_DAY = 10;

    @Override
    public String name() {
        return "Screw pile";
    }

    @Override
    public FoundationPlan plan(HouseSpec house) {
        int pileCount = (int) Math.ceil(house.perimeterMeters() / PILE_SPACING_METERS);
        int days = (int) Math.ceil((double) pileCount / PILES_PER_DAY);
        return new FoundationPlan(name(), 0, days, pileCount * COST_PER_PILE_USD);
    }
}
