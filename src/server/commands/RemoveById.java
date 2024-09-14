package server.commands;

import client.TerminalManager;
import server.CollectionManager;
import server.model.Dragon;

import java.util.ArrayList;
import java.util.LinkedList;

public class RemoveById extends Command {
    private final TerminalManager tm = new TerminalManager();
    private final CollectionManager collectionManager;
    public RemoveById(String name, String description, int amountOfArguments, CollectionManager collectionManager) {
        super(name, description, amountOfArguments);
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
                collectionManager.removeDragon(dragon);
                return;
            }
        }
        tm.printText("[!] Could not find dragon with id " + id + '.');
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int getAmountOfArguments() {
        return super.getAmountOfArguments();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
