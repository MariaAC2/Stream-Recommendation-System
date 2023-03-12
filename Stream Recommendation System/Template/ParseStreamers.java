package Template;

import Database.Database;
import Streamers.Streamer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ParseStreamers extends ParserTemplate {

    public ParseStreamers(String filename) {
        super(filename);
    }

    @Override
    public void processData(Database database) {
        List<String> data = super.getData();
        for (int i = 1; i < data.size(); i++) {
            String[] dataString = data.get(i).split(",");
            int streamerType = Integer.parseInt(dataString[0].replace("\"", ""));
            int id = Integer.parseInt(dataString[1].replace("\"", ""));
            String name = dataString[2].replace("\"", "");

            Streamer streamer = new Streamer(streamerType, id, name);
            database.getStreamers().put(id, streamer);
        }
    }

}
