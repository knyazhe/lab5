package server.commands;

import server.CollectionManager;
import server.DragonCreator;
import server.model.Dragon;

import java.util.ArrayList;

public class Add extends Command {
    private final CollectionManager collectionManager;

    public Add(String name, String description, CollectionManager collectionManager) {
        super(name, description);
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(ArrayList<String> arguments) {
        Dragon dragon = DragonCreator.createDragon();
        this.collectionManager.addDragon(dragon);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
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
    public String   toString() {
        return "Add{} " + super.toString();
    }


}
