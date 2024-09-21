package server.commands;

import client.TerminalManager;
import server.CollectionManager;
import server.model.MyCollection;


import java.util.ArrayList;

public class Show extends Command {
    private final CollectionManager collectionManager;
    private final TerminalManager terminalManager = new TerminalManager();
    public Show(String name, String description, int amountOfArguments, CollectionManager collectionManager) {
        super(name, description, amountOfArguments);
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(ArrayList<String> arguments) {
        MyCollection collection = collectionManager.getCollection();
        terminalManager.printCollection(collection);
    }


    @Override
    public String toString() {
        return "Show{" +
                "collectionManager=" + collectionManager +
                ", terminalManager=" + terminalManager +
                "} " + super.toString();
    }
}
