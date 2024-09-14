package server.commands;

import server.CollectionManager;

import java.util.ArrayList;

public class Clear extends Command {
    private final CollectionManager collectionManager;

    public Clear(String name, String description, int amountOfArguments, CollectionManager collectionManager) {
        super(name, description, amountOfArguments);
        this.collectionManager = collectionManager;
    }


    @Override
    public void apply(ArrayList<String> arguments) {
        this.collectionManager.clearCollection();
    }
}
