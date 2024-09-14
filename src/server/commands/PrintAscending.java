package server.commands;

import client.TerminalManager;
import server.CollectionManager;
import server.model.MyCollection;

import java.util.ArrayList;

public class PrintAscending extends Command{

    private final CollectionManager collectionManager;
    private final TerminalManager terminalManager = new TerminalManager();
    public PrintAscending(String name, String description, int amountOfArguments, CollectionManager collectionManager) {
        super(name, description, amountOfArguments);
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(ArrayList<String> arguments) {
        MyCollection sortedCollection;
        sortedCollection = collectionManager.sortDragons(new SortByAge());
        terminalManager.printCollection(sortedCollection);
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
