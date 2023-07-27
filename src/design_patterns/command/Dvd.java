package design_patterns.command;

public class Dvd implements Receiver{

    @Override
    public void switchOn() {
        System.out.println("Switch on from DVDPlayer");
    }
}
