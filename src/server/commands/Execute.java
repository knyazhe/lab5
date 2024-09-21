package server.commands;

import client.TerminalManager;
import server.CommandManager;
import server.ScriptManager;

import java.util.ArrayList;

public class Execute extends Command {
    private final TerminalManager terminalManager = new TerminalManager();
    private final CommandManager commandManager;
    public Execute(String name, String description, int amountOfArguments, CommandManager commandManager) {
        super(name, description, amountOfArguments);
        this.commandManager = commandManager;

    }

    @Override
    public void apply(ArrayList<String> arguments) {
        terminalManager.printText("[i] Start script execution\n"+arguments.get(0)+"\nrecursion level "+0+"\n");
        String path = arguments.get(0);
        Execute exec = this;
        ScriptManager sr = new ScriptManager(commandManager, path, 0, exec);
    }

    @Override
    public void apply(ArrayList<String> arguments, int recursionLevel) {
        terminalManager.printText("[i] Start script execution\n"+arguments.get(0)+"\nrecursion level "+recursionLevel+"\n");
        String path = arguments.get(1);
        Execute exec = this;
        ScriptManager sr = new ScriptManager(commandManager, path, recursionLevel, exec);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int getAmountOfArguments() {
        return super.getAmountOfArguments();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
