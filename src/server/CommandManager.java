package server;

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

    public CommandManager(CollectionManager collectionManager,Exit exit, Help help) {
        this.collectionManager = collectionManager;
        this.exit = exit;
        this.help = help;
        this.commands.put(exit.getName(), exit);
        this.help.addCommand(exit);
    }
    public void addCommand(Command command) {
        this.commands.put(command.getName(),command);
        this.help.addCommand(command);

    }
    public void removeCommand(Command command) {
        this.commands.remove(command.getName());
        this.help.removeCommand(command);
    }
    public void processCommand(ArrayList<String> str_from_user){
        if (this.commands.containsKey(str_from_user.get(0))) {
            Command user_command = this.commands.get(str_from_user.get(0));
            str_from_user.remove(0);
            user_command.apply(str_from_user);
        }else if (str_from_user.get(0).equals("help")) {
            this.help.apply();
        }
    }
}
