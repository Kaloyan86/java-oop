package interfaces_and_abstraction.military.implementations;

import java.util.Collection;

import interfaces_and_abstraction.military.interfaces.LieutenantGeneral;
import interfaces_and_abstraction.military.interfaces.Private;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    private Collection<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName,
                                 String lastName,
                                 double salary,
                                 Collection<Private> privateCollections) {
        super(id, firstName, lastName, salary);
        this.privates = privateCollections;
    }

    @Override
    public Collection<Private> getPrivates() {
        return this.privates;
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }
}
