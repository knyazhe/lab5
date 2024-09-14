package server.commands;

import java.util.ArrayList;

public class Exit extends Command {
    public Exit(String name, String description, int amountOfArguments) {
        super(name, description, amountOfArguments);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return super.toString();
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
    public void apply() {
        System.out.println("Exit");
        System.exit(0);

    }
    @Override
    public void apply(ArrayList<String> arguments) {
        this.apply();
    }
}
