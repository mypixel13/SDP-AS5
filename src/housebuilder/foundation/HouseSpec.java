package housebuilder.foundation;


public record HouseSpec(double lengthMeters, double widthMeters) {

    public double perimeterMeters() {
        return 2 * (lengthMeters + widthMeters);
    }

    public double footprintAreaSquareMeters() {
        return lengthMeters * widthMeters;
    }
}
