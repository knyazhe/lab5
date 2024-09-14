package server.commands;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Command{
    private final String name;
    private final String description;
    private final int amountOfArguments;

    public Command( String name, String description, int amountOfArguments ) {
        this.description = description;
        this.name = name;
        this.amountOfArguments = amountOfArguments;
    }

    public void apply(){

    }

    public void apply(ArrayList<String> arguments){

    }

    public void apply(ArrayList<String> arguments, int recursionLevel){

    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfArguments() {
        return amountOfArguments;
    }

    @Override
    public String toString() {
        return "Command{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return Objects.equals(getName(), command.getName()) && Objects.equals(getDescription(), command.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription());
    }
}
