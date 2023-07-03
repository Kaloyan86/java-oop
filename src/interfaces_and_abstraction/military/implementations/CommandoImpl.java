package interfaces_and_abstraction.military.implementations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import interfaces_and_abstraction.military.interfaces.Commando;
import interfaces_and_abstraction.military.interfaces.Mission;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private Collection<Mission> missions;

    public CommandoImpl(int id,
                        String firstName,
                        String lastName,
                        double salary,
                        String corps,
                        Collection<Mission> missions) {
        super(id, firstName, lastName, salary, corps);
        this.setMissions(missions);
    }

    public void setMissions(Collection<Mission> missions) {
        if (missions != null) {
            this.missions = missions;
        } else {
            this.missions = new ArrayList<>();
        }
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }
}
