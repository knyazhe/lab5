package server.commands;

import client.TerminalManager;

import java.util.ArrayList;

public class Help extends Command {
    private final TerminalManager terminalManager = new TerminalManager();
    ArrayList<Command> commands = new ArrayList<Command>();

    public Help(String name, String description, int amountOfArguments) {
        super(name, description, amountOfArguments);
    }

    @Override
    public void apply() {
        for (Command c : commands) {
            terminalManager.printTable(c.getName(), c.getDescription());
        }
        terminalManager.printTable(this.getName(), this.getDescription());
    }

    public void addCommandToHelp(Command command) {
        this.commands.add(command);
    }

    public void removeCommandFromHelp(Command command) {
        this.commands.remove(command);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
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
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
