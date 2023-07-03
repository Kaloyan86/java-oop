package interfaces_and_abstraction.military.implementations;

import java.util.ArrayList;
import java.util.Collection;

import interfaces_and_abstraction.military.interfaces.Engineer;
import interfaces_and_abstraction.military.interfaces.Repair;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    private Collection<Repair> repairs;

    public EngineerImpl(int id,
                        String firstName,
                        String lastName,
                        double salary,
                        String corps,
                        Collection<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.setRepairs(repairs);
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    public void setRepairs(Collection<Repair> repairs) {
        if (repairs != null) {
            this.repairs = repairs;
        } else {
            this.repairs = new ArrayList<>();
        }
    }
}
