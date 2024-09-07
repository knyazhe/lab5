import client.TerminalManager;
import server.CollectionManager;
import server.CommandManager;
import server.commands.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        TerminalManager terminalManager = new TerminalManager();
        CommandManager commandManager = new CommandManager(
                collectionManager,
                terminalManager,
                new Exit("exit", "end program (without save)"),
                new Help("help", "display help with the available commands"));

        commandManager.addCommand(new Clear("clear", "delete ellelement incollection", collectionManager));
        commandManager.addCommand(new Add("add", "add element to collection", collectionManager));
        commandManager.addCommand(new Show("show", "show all elements in collection", collectionManager, terminalManager));
        commandManager.addCommand(new RemoveById("remove_by_id", "remove element by id", collectionManager));
        commandManager.addCommand(new Update("update", "update information of element by id", collectionManager));



        while (true) {
            ArrayList<String> input = terminalManager.stdinlist();
            commandManager.processCommand(input);
        }
    }
}