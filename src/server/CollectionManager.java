package server;

import server.model.Dragon;

import java.util.LinkedList;

public class CollectionManager {
    public CollectionManager() {
        LinkedList<Dragon> collection = new LinkedList<Dragon>();

//        server.DragonCreator creator = new server.DragonCreator();
//        Dragon gensek = new Dragon();
//        Dragon noname = new Dragon();
//
//        creator.Fill(gensek);
//        creator.Fill(noname);
//        collection.add(gensek);
//        collection.add(noname);

        for (var e : collection) System.out.println(e);
    }
}
