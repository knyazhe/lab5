package server;

import server.model.Dragon;

import java.util.LinkedList;

public class CollectionManager {
    private LinkedList<Dragon> collection;
    public CollectionManager() {
        collection = new LinkedList<Dragon>(); //Сделать generic на дюбой Object
    }

    public LinkedList<Dragon> getCollection() {
        return collection;
    }

    public void clearCollection() {
        collection.clear();
    }

    public void setCollection(LinkedList<Dragon> collection) {
        this.collection = collection;
    }

    public void addDragon(Dragon dragon) {
        collection.add(dragon);
    }
}
