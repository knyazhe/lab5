package server.commands;

import server.CollectionManager;

import java.util.ArrayList;

public class Clear extends Command {
    private CollectionManager collectionManager;

    public Clear(String name, String description, CollectionManager collectionManager) {
        super(name, description);
        this.collectionManager = collectionManager;
    }


    @Override
    public void apply(ArrayList<String> arguments) {
        this.collectionManager.clearCollection();
    }
}
