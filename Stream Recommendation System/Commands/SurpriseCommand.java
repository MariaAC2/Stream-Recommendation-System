package Commands;

import Database.Database;
import Streams.Stream;
import Users.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SurpriseCommand extends Command{
    @Override
    public void execute(String data, Database database) {
        String[] dataString = data.split(" ");
        int userId = Integer.parseInt(dataString[0]);
        int streamType = 0;

        if (dataString[2].equals("SONG")) {
            streamType = 1;
        } else if (dataString[2].equals("PODCAST")) {
            streamType = 2;
        } else {
            streamType = 3;
        }

        List<Stream> listOfSurprises = database.getSurprise(userId, streamType);
        String show = database.print(listOfSurprises);

        System.out.println(show);
    }
}
