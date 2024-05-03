package commands;

public class Exit extends Command {
    public Exit(String description, String name) {
        super(description, name);
    }

    @Override
    public void apply() {
        System.exit(0);
    }
}
