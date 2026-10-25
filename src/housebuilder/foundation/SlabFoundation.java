package housebuilder.foundation;


public class SlabFoundation implements FoundationStrategy {

    private static final double SLAB_THICKNESS_METERS = 0.3;
    private static final double COST_PER_CUBIC_METER_USD = 260;
    private static final double SQUARE_METERS_PER_DAY = 15;
    private static final int CONCRETE_CURING_DAYS = 10;

    @Override
    public String name() {
        return "Slab";
    }

    @Override
    public FoundationPlan plan(HouseSpec house) {
        double concrete = house.footprintAreaSquareMeters() * SLAB_THICKNESS_METERS;
        int days = (int) Math.ceil(house.footprintAreaSquareMeters() / SQUARE_METERS_PER_DAY) + CONCRETE_CURING_DAYS;
        return new FoundationPlan(name(), concrete, days, concrete * COST_PER_CUBIC_METER_USD);
    }
}
