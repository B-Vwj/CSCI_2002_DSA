package spacesurvival;

public class AlienEncounter implements EnergyEventIdea {

    private int energy;

    public AlienEncounter(int energy) {
        setEnergy(energy);
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
