package Commands;

import Database.Database;
import Streamers.Streamer;
import Streams.Stream;
import Users.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ListCommand extends Command{
    @Override
    public void execute(String data, Database database) {
        String[] info = data.split(" ");
        int id = Integer.parseInt(info[0]);

        List<Stream> streams = new ArrayList<>();

        if (database.getStreamers().containsKey(id)) {
            Streamer streamer = database.getStreamers().get(id);
            streams = streamer.getStreams();
            System.out.println(database.print(streams));
        } else {
            User user = database.getUsers().get(id);
            streams = user.getStreams();
            System.out.println(database.print(streams));
        }
    }
}