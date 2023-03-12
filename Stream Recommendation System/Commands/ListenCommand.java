package Commands;

import Database.Database;
import Streams.Stream;
import Users.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ListenCommand extends Command{
    @Override
    public void execute(String data, Database database) {
        String[] info = data.split(" ");
        int userId = Integer.parseInt(info[0]);
        int streamId = Integer.parseInt(info[2]);

        User user = database.getUsers().get(userId);
        Stream stream = database.getStreams().get(streamId);
        user.getStreams().add(stream);
        stream.addNoOfStreams();
    }
}
