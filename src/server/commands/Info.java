package server.commands;

import client.TerminalManager;
import server.CollectionManager;

import java.util.ArrayList;

public class Info extends Command{
    private final CollectionManager collectionManager;
    private TerminalManager terminalManager = new TerminalManager();
    public Info(String name, String description, CollectionManager collectionManager) {
        super(name, description);
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(ArrayList<String> arguments) {
        terminalManager.printText("amount of elements: " + collectionManager.getCollection().size()+ "\n" +
                "init date: " + collectionManager.getCollection().getInitializationDate()+"\n" +
                "type: "+collectionManager.getCollection().getClass().getSuperclass()+"\n");
    }
}
