package server.commands;

import client.TerminalManager;
import server.CollectionManager;
import server.model.Dragon;


import java.util.ArrayList;
import java.util.LinkedList;

public class Show extends Command {
    CollectionManager collectionManager;
    TerminalManager terminalManager;
    public Show(String name, String description, CollectionManager collectionManager, TerminalManager terminalManager) {
        super(name, description);
        this.collectionManager = collectionManager;
        this.terminalManager = terminalManager;
    }

    @Override
    public void apply(ArrayList<String> arguments) {
        LinkedList<Dragon> collection = collectionManager.getCollection();
        if (collection.isEmpty()) {
            terminalManager.printText("[i] Collection is empty.");
        } else {
            for (Dragon dragon : collection) {
                terminalManager.printText(dragon);
            }
        }
    }

    @Override
    public String toString() {
        return "Show{" +
                "collectionManager=" + collectionManager +
                ", terminalManager=" + terminalManager +
                "} " + super.toString();
    }
}
