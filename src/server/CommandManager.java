package server;

import client.TerminalManager;
import server.commands.Command;
import server.commands.*;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandManager {
//    private static commandsHistory;
    HashMap<String, Command> commands = new HashMap<String, Command>();
    private final Exit exit;
    private final Help help;
    private final CollectionManager collectionManager;
    private final TerminalManager terminalManager;

    public CommandManager(CollectionManager collectionManager, TerminalManager terminalManager, Exit exit, Help help) {
        this.collectionManager = collectionManager;
        this.terminalManager = terminalManager;
        this.exit = exit;
        this.help = help;
        this.commands.put(exit.getName(), exit);
        this.help.addCommandToHelp(exit);
    }
    public void addCommand(Command command) {
        this.commands.put(command.getName(),command);
        this.help.addCommandToHelp(command);

    }
    public void removeCommand(Command command) {
        this.commands.remove(command.getName());
        this.help.removeCommandFromHelp(command);
    }
    public void processCommand(ArrayList<String> str_from_user){
        if (this.commands.containsKey(str_from_user.get(0))) {
            Command user_command = this.commands.get(str_from_user.get(0));
            str_from_user.remove(0);
            try {
                user_command.apply(str_from_user);
            }
            catch (Throwable e){
                terminalManager.printText("ERROR: Command " + str_from_user.get(0) + " could not be applied.");
            }

        }else if (str_from_user.get(0).equals("help")) {
            this.help.apply();
        }else{
            terminalManager.printText("[!] Command not found. Write 'help' to find out the list of available commands.");
        }
    }
}
