package Template;
import Database.Database;
import Streamers.Streamer;
import Streams.Stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ParseStreams extends ParserTemplate{
    public ParseStreams(String filename) {
        super(filename);
    }

    @Override
    public void processData(Database database) {
        List<String> data = super.getData();
        for (int i = 1; i < data.size(); i++) {
            String[] dataString = data.get(i).split(",", 8);
            int streamType = Integer.parseInt(dataString[0].replace("\"", ""));
            int id = Integer.parseInt(dataString[1].replace("\"", ""));
            int streamGenre = Integer.parseInt(dataString[2].replace("\"", ""));
            long noOfStreams = Long.parseLong(dataString[3].replace("\"", ""));
            int streamerId = Integer.parseInt(dataString[4].replace("\"", ""));
            long length = Long.parseLong(dataString[5].replace("\"", ""));
            long dateAdded = Long.parseLong(dataString[6].replace("\"", ""));
            String name = dataString[7].replace("\"", "");

            Stream stream = new Stream(streamType, id, streamGenre, noOfStreams, streamerId, length, dateAdded, name);
            database.getStreams().put(id, stream);
            Streamer streamer = database.getStreamers().get(streamerId);
            streamer.getStreams().add(stream);
        }
    }
}
