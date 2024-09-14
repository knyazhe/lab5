package server;

import server.model.Dragon;
import server.model.MyCollection;

import java.util.Comparator;
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

    public void setMyCollection(MyCollection collection) {
        this.collection = collection;
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
    public void removeDragon(Dragon dragon) {
        collection.remove(dragon);
    }
    public MyCollection sortDragons(Comparator<Dragon> comparator) {
        MyCollection sortedCollection = new MyCollection();
        sortedCollection = (MyCollection) collection.clone();
        sortedCollection.sort(comparator);
        return sortedCollection;
    }
}
