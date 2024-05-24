import client.TerminalManager;
import server.CollectionManager;
import server.CommandManager;
import server.commands.Exit;
import server.commands.Help;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        CommandManager commandManager = new CommandManager(
                collectionManager,
                new Exit("exit", "завершить программу (без сохранения в файл)"),
                new Help("help", "вывести справку по доступным командам"));
        TerminalManager console = new TerminalManager();

        while (true) {
            ArrayList<String> input = console.stdinlist();
            commandManager.processCommand(input);
        }
    }
}