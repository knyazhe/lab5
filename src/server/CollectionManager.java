package server;

import client.JsonManager;
import server.model.Dragon;
import server.model.MyCollection;

import java.util.Comparator;

public class CollectionManager {
    private MyCollection collection;
    private long id_counter;
    public CollectionManager() {
        MyCollection coll = JsonManager.loadFromJson();
        if (coll!=null){
            collection = coll;
        }else{
            collection = new MyCollection();
        }
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
        dragon.setId((long) collection.size());
        collection.add(dragon);
    }
    public void removeDragon(Dragon dragon) {
        collection.remove(dragon);
    }

    public MyCollection sortDragons(Comparator<Dragon> comparator) {
        MyCollection sortedCollection = (MyCollection) collection.clone();
        sortedCollection.sort(comparator);
        return sortedCollection;
    }
}
