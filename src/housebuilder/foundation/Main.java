package housebuilder.foundation;

public class Main {

    public static void main(String[] args) {
        HouseSpec house = new HouseSpec(12, 9);

        FoundationSelector selector = new FoundationSelector()
                .register(SoilType.ROCKY, new StripFoundation())
                .register(SoilType.SANDY, new SlabFoundation())
                .register(SoilType.CLAY, new PileFoundation());

        System.out.println("=== House 12 x 9 m: foundation chosen by soil ===");
        HouseBuilder builder = new HouseBuilder(selector.forSoil(SoilType.ROCKY));
        for (SoilType soil : new SoilType[]{SoilType.ROCKY, SoilType.SANDY, SoilType.CLAY}) {
            builder.setFoundationStrategy(selector.forSoil(soil));   // runtime switch
            System.out.printf("%-6s -> %s%n", soil, builder.planFoundation(house));
        }

        System.out.println();
        System.out.println("=== Extension: new strategy, no existing class modified ===");
        selector.register(SoilType.PEAT, new ScrewPileFoundation());
        builder.setFoundationStrategy(selector.forSoil(SoilType.PEAT));
        System.out.printf("%-6s -> %s%n", SoilType.PEAT, builder.planFoundation(house));
    }
}
