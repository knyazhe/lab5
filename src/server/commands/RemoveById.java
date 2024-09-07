package server.commands;

import client.TerminalManager;
import server.CollectionManager;
import server.model.Dragon;

import java.util.ArrayList;
import java.util.LinkedList;

public class RemoveById extends Command {
    private final TerminalManager tm = new TerminalManager();
    private final CollectionManager collectionManager;
    public RemoveById(String name, String description, CollectionManager collectionManager) {
        super(name, description);
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(ArrayList<String> arguments) {
        Long id;
        try {
            id = Long.parseLong(arguments.get(0));
        }catch (Throwable e){
            tm.printText("[!] Not enough arguments!");
            return;
        }
        LinkedList<Dragon> collection = collectionManager.getCollection();
        for (Dragon dragon: collection){
            if (dragon.getId().equals(id)){
                collection.remove(dragon);
                return;
            }
        }
        tm.printText("[!] Could not find dragon with id " + id + '.');
    }
}
