package server.commands;

import client.JsonManager;
import server.CollectionManager;

import java.util.ArrayList;

public class Save extends Command {
    private CollectionManager collectionManager;
    public Save(String name, String description, int amountOfArguments, CollectionManager collectionManager) {
        super(name, description, amountOfArguments);
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(ArrayList<String> arguments) {
        JsonManager.saveToJson(collectionManager.getCollection());
    }

}
