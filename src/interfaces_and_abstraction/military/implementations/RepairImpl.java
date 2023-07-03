package interfaces_and_abstraction.military.implementations;

import interfaces_and_abstraction.military.interfaces.Repair;

public class RepairImpl implements Repair {
    private String partName;
    private int workedHours;

    public RepairImpl(String partName, int workedHours) {
        this.partName = partName;
        this.workedHours = workedHours;
    }

    @Override
    public String getPartName() {
        return this.partName;
    }
    // TODO check name
    @Override
    public int getWorkedHours() {
        return this.workedHours;
    }
}
