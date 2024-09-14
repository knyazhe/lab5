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
    public void processCommand(ArrayList<String> strFromUser){
        String command = strFromUser.remove(0);
        ArrayList<String> argue = strFromUser;
        if (this.commands.containsKey(command)) {
            Command userCommand = this.commands.get(command);
            try {
                if (userCommand.getAmountOfArguments() == argue.size()) {
                    userCommand.apply(argue);
                } else {
                    terminalManager.printText("[!] Wrong arguments " + argue.size() + " instead of " + userCommand.getAmountOfArguments());
                }
            }
            catch (Throwable e){
                terminalManager.printText("ERROR: Command " + command + " could not be applied. \n"+ e);
            }

        }else if (command.equals("help")) {
            this.help.apply();
        }else{
            terminalManager.printText("[!] Command not found. Write 'help' to find out the list of available commands.");
        }
    }
}
