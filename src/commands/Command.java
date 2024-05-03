package commands;

import java.util.Objects;

public abstract class Command{
    private final String name;
    private final String description;

    public Command(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public void apply(){

    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
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
