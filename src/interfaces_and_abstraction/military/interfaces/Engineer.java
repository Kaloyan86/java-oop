package interfaces_and_abstraction.military.interfaces;

import java.util.Collection;

public interface Engineer {

    void addRepair(Repair repair);

    Collection<Repair> getRepairs();

}
