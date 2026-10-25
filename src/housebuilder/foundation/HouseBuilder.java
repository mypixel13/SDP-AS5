package housebuilder.foundation;

import java.util.Objects;


public class HouseBuilder {

    private FoundationStrategy foundationStrategy;

    public HouseBuilder(FoundationStrategy foundationStrategy) {
        setFoundationStrategy(foundationStrategy);
    }

    public void setFoundationStrategy(FoundationStrategy foundationStrategy) {
        this.foundationStrategy = Objects.requireNonNull(foundationStrategy, "foundationStrategy");
    }

    public FoundationPlan planFoundation(HouseSpec house) {
        return foundationStrategy.plan(house);
    }
}
