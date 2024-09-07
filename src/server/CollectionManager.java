package server;

import server.model.Dragon;
import server.model.MyCollection;

import java.util.LinkedList;

public class CollectionManager {
    private MyCollection collection = new MyCollection();
    private static long id_counter = 1;
    public CollectionManager() {
        collection = new MyCollection(); //Сделать generic на дюбой Object
    }

    public MyCollection getCollection() {
        return collection;
    }

    public void clearCollection() {
        collection.clear();
    }

    public void setCollection(MyCollection collection) {
        this.collection = collection;
    }

    public void addDragon(Dragon dragon) {
        dragon.setId(id_counter++);
        collection.add(dragon);
    }
}
