package Commands;

import Database.Database;

public abstract class Command {
    public Command() {}

    public abstract void execute(String data, Database database);
}
