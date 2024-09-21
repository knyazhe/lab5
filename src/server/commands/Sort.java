package server.commands;

import server.CollectionManager;

import java.util.ArrayList;

public class Sort extends Command{
    private final CollectionManager collectionManager;

    public Sort(String name, String description, int amountOfArguments, CollectionManager collectionManager) {
        super(name, description, amountOfArguments);
        this.collectionManager = collectionManager;
    }


    @Override
    public void apply(ArrayList<String> arguments) {
        collectionManager.sortDragons(new SortByAge());
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
