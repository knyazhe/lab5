package server.commands;

import client.TerminalManager;
import server.CollectionManager;
import server.model.Dragon;

import java.util.ArrayList;
import java.util.LinkedList;

public class FilterContains extends Command {
    CollectionManager collectionManager;
    TerminalManager terminalManager;
    public FilterContains(String name, String description, CollectionManager collectionManager, TerminalManager terminalManager) {
        super(name, description);
        this.collectionManager = collectionManager;
        this.terminalManager = terminalManager;
    }

    @Override
    public void apply(ArrayList<String> arguments) {
        LinkedList<Dragon> collection = collectionManager.getCollection();
        String str;
        try {
            str = arguments.get(0);
        }catch (Throwable e){
            terminalManager.printText("[!] Not enough arguments!");
            return;
        }
        if (collection.isEmpty()) {
            terminalManager.printText("[i] Collection is empty.");
        } else {
            for (Dragon dragon : collection) {
                if (dragon.getName().startsWith(str)) {
                    terminalManager.printText(dragon);
                }
            }
        }
    }
}
