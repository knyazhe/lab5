package server.commands;

import java.util.ArrayList;

public class Help extends Command {
    ArrayList<Command> commands = new ArrayList<Command>();
    public Help(String name, String description) {
        super(name, description);
    }

    @Override
    public void apply() {
        for (Command c : commands) {
            System.out.printf(" %-35s%-1s%n", c.getName(), c.getDescription());
        }
        System.out.printf(" %-35s%-1s%n", this.getName(), this.getDescription());
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    public void removeCommand(Command command) {
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
