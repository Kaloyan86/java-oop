package interfaces_and_abstraction.military.implementations;

import interfaces_and_abstraction.military.interfaces.Mission;

public class MissionImpl implements Mission {

    private static final String IN_PROGRESS = "inProgress";
    private static final String FINISHED = "finished";

    private String codeName;
    private String state;

    public MissionImpl(String codeName, String state) {
        this.setCodeName(codeName);
        this.setState(state);
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public void setState(String state) {
        if (IN_PROGRESS.equals(state) || FINISHED.equals(state)) {
            this.state = state;
        }
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void completeMission() {
        this.setState(FINISHED);
    }
}
