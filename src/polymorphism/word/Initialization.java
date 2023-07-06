package polymorphism.word;

public class Initialization {

    public static CommandInterface buildCommandInterface(StringBuilder text){
        CommandInterface commandInterface = new CommandImpl(text);
        commandInterface.init();
        return commandInterface;
    }
}
