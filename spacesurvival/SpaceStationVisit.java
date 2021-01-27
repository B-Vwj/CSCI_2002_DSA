package spacesurvival;

public class SpaceStationVisit implements EnergyEventIdea {

    private int fuel;

    public SpaceStationVisit(int fuel) {
        setFuel(fuel);
    }

    public int getEnergy() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
}
