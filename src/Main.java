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
                new Exit("exit", "завершить программу (без сохранения в файл)"),
                new Help("help", "вывести справку по доступным командам"));

        commandManager.addCommand(new Clear("clear", "clear", collectionManager));
        commandManager.addCommand(new Add("add", "add", collectionManager));
        commandManager.addCommand(new Show("show", "shooe", collectionManager, terminalManager));

        while (true) {
            ArrayList<String> input = terminalManager.stdinlist();
            commandManager.processCommand(input);
        }
    }
}