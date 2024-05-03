import model.Dragon;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
//        CollectionManager collectionManager = new CollectionManager();
//        CommandManager commandManager = new CommandManager();
        LinkedList<Dragon> collection = new LinkedList<Dragon>();




        Dragon gensek = DragonCreator.createDragon();
        Dragon noname = DragonCreator.createDragon();
        collection.add(gensek);
        collection.add(noname);

        for (var e : collection) System.out.println(e);
    }
}