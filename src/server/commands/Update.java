package server.commands;

import client.TerminalManager;
import server.CollectionManager;
import server.DragonCreator;
import server.model.Dragon;

import java.util.ArrayList;
import java.util.LinkedList;

public class Update extends Command {
    private final TerminalManager terminalManager = new TerminalManager();
    private final CollectionManager collectionManager;
    public Update(String name, String description, int amountOfArguments, CollectionManager collectionManager) {
        super(name, description, amountOfArguments);
        this.collectionManager = collectionManager;
    }
    @Override
    public void apply(ArrayList<String> arguments) {
        Long id;
        try {
            id = Long.parseLong(arguments.get(0));
        }catch (Throwable e){
            terminalManager.printText("[!] Not enough arguments!");
            return;
        }
        LinkedList<Dragon> collection = collectionManager.getCollection();
        for (Dragon dragon: collection){
            if (dragon.getId().equals(id)){
                Dragon new_dragon = DragonCreator.createDragon();
                new_dragon.setId(id);
                collection.remove(dragon);
                collection.add(new_dragon);
                return;
            }
        }
        terminalManager.printText("[!] Could not find dragon with id " + id + '.');
    }
}
