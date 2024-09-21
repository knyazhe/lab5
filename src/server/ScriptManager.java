package server;

import client.ScriptReader;
import client.TerminalManager;
import server.commands.Execute;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class ScriptManager {
    ScriptReader scriptReader;
    Execute executeCommand;
    TerminalManager terminalManager = new TerminalManager();
    public ScriptManager(CommandManager commandManager, String path, int recursionLevel, Execute executeCommand) {
        this.executeCommand = executeCommand;
        scriptReader = new ScriptReader(path);
        while (true) {
            LinkedList<String> line = scriptReader.readLine();
            if (line == null) {
                terminalManager.printText("[i] Script " + path +" is done!\nRecursion level: " + recursionLevel);
                break;
            } else if (line.size()>1 &&
                       Objects.equals(line.get(1), scriptReader.getPath()) &&
                       Objects.equals(line.get(0), executeCommand.getName())
                      )
            {
                if (recursionLevel<228) {
                    ArrayList<String> arrayLine = new ArrayList<String>(line);
                    this.executeCommand.apply(arrayLine, recursionLevel+1);
                } else {
                    terminalManager.printText("[i] Maximum recursion level is 228");
                }

            } else {
                ArrayList<String> arrayLine = new ArrayList<String>(line);
                commandManager.processCommand(arrayLine);
            }
        }
    }
    public void loadScript() {}

}
