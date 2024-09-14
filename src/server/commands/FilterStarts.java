package server.commands;

import client.TerminalManager;
import server.CollectionManager;
import server.model.Dragon;

import java.util.ArrayList;
import java.util.LinkedList;

public class FilterStarts extends Command {
    private final CollectionManager collectionManager;
    private final TerminalManager terminalManager = new TerminalManager();
    public FilterStarts(String name, String description, int amountOfArguments, CollectionManager collectionManager) {
        super(name, description, amountOfArguments);
        this.collectionManager = collectionManager;
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
