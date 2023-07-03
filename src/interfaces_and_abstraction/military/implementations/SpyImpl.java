package interfaces_and_abstraction.military.implementations;

import interfaces_and_abstraction.military.interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {

    private int codeNumber;

    public SpyImpl(int id, String firstName, String lastName, int codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    public void setCodeNumber(int codeNumber) {
        this.codeNumber = codeNumber;
    }

    @Override
    public int getCodeNumber() {
        return this.codeNumber;
    }
}
