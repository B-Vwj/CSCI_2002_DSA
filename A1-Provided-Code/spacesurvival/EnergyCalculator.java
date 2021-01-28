package spacesurvival;

import java.util.List;

public class EnergyCalculator {

    private List<EnergyEventIdea> energySources;
    private int totalEnergy = 0;

    public EnergyCalculator(List<EnergyEventIdea> source) {
        setEnergySources(source);
    }

    public int getTotalEnergy() {
        return totalEnergy;
    }

    public void setEnergySources(List<EnergyEventIdea> energySources) {
        this.energySources = energySources;
    }

    public void compute() {

        for (int i = 0; i < energySources.size(); i++) {
            this.totalEnergy += energySources.get(i).getEnergy();
        }
    }
}
