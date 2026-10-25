package housebuilder.foundation;


public interface FoundationStrategy {

    String name();

    FoundationPlan plan(HouseSpec house);
}
