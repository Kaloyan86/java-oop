package design_patterns.command;

/*
The Command pattern intends to encapsulate in an object
all the data required for performing a given action (command),
including what method to call, the method's arguments,
and the object to which the method belongs.
This model allows us to decouple objects that produce the commands from their consumers,
so that's why the pattern is commonly known as the producer-consumer pattern.
 */
public class CommandMain {

    public static void main(String args[]) {
        // On command for TV with same invoker
        Receiver receiver = new Tv();
        Command onCommand = new OnCommand(receiver);

        Invoker invoker = new Invoker(onCommand);
        invoker.execute();

        // On command for DVDPlayer with same invoker
        receiver = new Dvd();
        onCommand = new OnCommand(receiver);

        invoker = new Invoker(onCommand);
        invoker.execute();
    }
}
