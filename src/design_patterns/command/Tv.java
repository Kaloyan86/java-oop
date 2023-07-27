package design_patterns.command;

public class Tv implements Receiver{

    @Override
    public void switchOn() {
        System.out.println("Switch on from TV");
    }
}
