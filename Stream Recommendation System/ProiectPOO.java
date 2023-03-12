import Database.Database;
import Template.ParseCommands;
import Template.ParseStreamers;
import Template.ParseStreams;
import Template.ParseUsers;

import static Database.Database.getDbInstance;

public class ProiectPOO {
    public static void main(String[] args) {
        if (args == null) {
            System.out.println("Nothing to read here");
            return;
        }

        String[] newArgs = new String[4];
        for (int i = 0; i < args.length; i++) {
            newArgs[i] = "src/main/resources/" + args[i];
        }

        Database database = getDbInstance();

        ParseStreamers parseStreamers = new ParseStreamers(newArgs[0]);
        parseStreamers.processData(database);

        ParseStreams parseStreams = new ParseStreams(newArgs[1]);
        parseStreams.processData(database);

        ParseUsers parseUsers = new ParseUsers(newArgs[2]);
        parseUsers.processData(database);

        ParseCommands parseCommands = new ParseCommands(newArgs[3]);
        parseCommands.processData(database);
    }
}
