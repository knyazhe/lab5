import client.TerminalManager;
import server.CollectionManager;
import server.CommandManager;
import server.ScriptManager;
import server.commands.*;
import server.model.Coordinates;
import server.model.Dragon;
import server.model.DragonHead;
import server.model.enums.Color;
import server.model.enums.DragonCharacter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        TerminalManager terminalManager = new TerminalManager();
        CommandManager commandManager = new CommandManager(
                collectionManager,
                terminalManager,
                new Exit("exit", "end program (without save)", 0),
                new Help("help", "display help with the available commands", 0));


        commandManager.addCommand(new Clear("clear", "delete ellelement incollection", 0, collectionManager));
        commandManager.addCommand(new Add("add", "add element to collection", 0, collectionManager));
        commandManager.addCommand(new Show("show", "show all elements in collection", 0, collectionManager));
        commandManager.addCommand(new RemoveById("remove_by_id", "remove element by id", 1, collectionManager));
        commandManager.addCommand(new Update("update", "update information of element by id", 1, collectionManager));
        commandManager.addCommand(new FilterContains("filter_contains_name", "filter elements by name contains string", 1, collectionManager));
        commandManager.addCommand(new FilterStarts("filter_starts_name", "filter elements by name starts from string", 1, collectionManager));
        commandManager.addCommand(new Info("info", "give info about collection", 0, collectionManager));
        commandManager.addCommand(new Sort("sort", "sort dragons by age (ascending)", 0, collectionManager));
        commandManager.addCommand(new PrintAscending("print_ascending", "print ascending sorted dragons", 0, collectionManager));
        commandManager.addCommand(new Execute("execute_script", "execute script file", 1, commandManager));

//        tmp
        collectionManager.addDragon(new Dragon(123, DragonCharacter.CUNNING, Color.BLUE, new Coordinates(1.0, 1.0),
                (LocalDateTime) null, new DragonHead((long) 50.0), 1L, "dragon1", true));
        collectionManager.addDragon(new Dragon(10, DragonCharacter.CUNNING, Color.BLUE, new Coordinates(1.0, 1.0),
                (LocalDateTime) null, new DragonHead((long) 50.0), 2L, "dragon2", true));
        collectionManager.addDragon(new Dragon(1, DragonCharacter.CUNNING, Color.BLUE, new Coordinates(1.0, 1.0),
                (LocalDateTime) null, new DragonHead((long) 50.0), 3L, "dragon3", true));
//        tmp

        while (true) {
            try {
                ArrayList<String> input = terminalManager.stdinlist();
                commandManager.processCommand(input);
            }catch (NoSuchElementException e){
                terminalManager.printText("just dont press ctrl+d");
            }
        }
    }
}