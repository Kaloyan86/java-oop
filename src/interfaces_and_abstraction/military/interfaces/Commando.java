package interfaces_and_abstraction.military.interfaces;

import java.util.Collection;

public interface Commando {

    void addMission(Mission mission);

    Collection<Mission> getMissions();

}
