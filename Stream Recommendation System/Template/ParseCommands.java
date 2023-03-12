package Template;

import Database.Database;
import Factory.CommandsFactory;

import java.util.List;

public class ParseCommands extends ParserTemplate{
    public ParseCommands(String filename) {
        super(filename);
    }

    @Override
    public void processData(Database database) {
        List<String> data = super.getData();
        for (int i = 0; i < data.size(); i++) {
            String dataString = data.get(i);
            CommandsFactory cf = new CommandsFactory();
            cf.getCommand(dataString).execute(dataString, database);
        }
    }
}
