package Template;

import Database.Database;
import Streams.Stream;
import Users.User;

import java.util.ArrayList;
import java.util.List;

public class ParseUsers extends ParserTemplate{
    public ParseUsers(String filename) {
        super(filename);
    }

    @Override
    public void processData(Database database) {
        List<String> data = super.getData();
        for (int i = 1; i < data.size(); i++) {
            String[] dataString = data.get(i).split(",", 3);
            int id = Integer.parseInt(dataString[0].replace("\"", ""));
            String name = dataString[1];
            String x = dataString[2].replace("\"", "");

            String[] IDs = x.split(" ");

            List<Stream> streams = new ArrayList<>();
            for (String s: IDs) {
                int streamId = Integer.parseInt(s);
                Stream stream = database.getStreams().get(streamId);
                streams.add(stream);
            }

            User user = new User(id, name, streams);
            database.getUsers().put(id, user);
        }
    }
}
