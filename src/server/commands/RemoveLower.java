package server.commands;

import client.TerminalManager;
import server.CollectionManager;
import server.DragonCreator;
import server.model.Dragon;

import java.util.ArrayList;

public class RemoveLower extends Command {

    private final TerminalManager terminalManager = new TerminalManager();
    private final CollectionManager collectionManager;
    public RemoveLower(String name, String description, int amountOfArguments, CollectionManager collectionManager) {
        super(name, description, amountOfArguments);
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(ArrayList<String> arguments) {
        Dragon filter_dragon = DragonCreator.createDragon();
        SortByAge mySortByAge = new SortByAge();
        for (Dragon dragon: collectionManager.getCollection()){
            if (mySortByAge.compare(dragon, filter_dragon) < 0) {
                collectionManager.removeDragon(dragon);
            }
        }
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
