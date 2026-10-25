package housebuilder.foundation;


public class StripFoundation implements FoundationStrategy {

    private static final double STRIP_WIDTH_METERS = 0.5;
    private static final double STRIP_DEPTH_METERS = 1.2;
    private static final double COST_PER_CUBIC_METER_USD = 210;
    private static final double METERS_OF_STRIP_PER_DAY = 6;
    private static final int CONCRETE_CURING_DAYS = 7;

    @Override
    public String name() {
        return "Strip";
    }

    @Override
    public FoundationPlan plan(HouseSpec house) {
        double concrete = house.perimeterMeters() * STRIP_WIDTH_METERS * STRIP_DEPTH_METERS;
        int days = (int) Math.ceil(house.perimeterMeters() / METERS_OF_STRIP_PER_DAY) + CONCRETE_CURING_DAYS;
        return new FoundationPlan(name(), concrete, days, concrete * COST_PER_CUBIC_METER_USD);
    }
}
