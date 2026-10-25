package housebuilder.foundation;

import java.util.EnumMap;
import java.util.Map;


public class FoundationSelector {

    private final Map<SoilType, FoundationStrategy> strategyBySoil = new EnumMap<>(SoilType.class);

    public FoundationSelector register(SoilType soil, FoundationStrategy strategy) {
        strategyBySoil.put(soil, strategy);
        return this;
    }

    public FoundationStrategy forSoil(SoilType soil) {
        FoundationStrategy strategy = strategyBySoil.get(soil);
        if (strategy == null) {
            throw new IllegalArgumentException("No foundation strategy registered for soil: " + soil);
        }
        return strategy;
    }
}
