package Commands;

import Database.Database;
import Streamers.Streamer;
import Streams.Stream;

public class DeleteCommand extends Command{
    @Override
    public void execute(String data, Database database) {
        String[] info = data.split(" ");
        int streamerId = Integer.parseInt(info[0]);
        int streamId = Integer.parseInt(info[2]);

        Streamer streamer = database.getStreamers().get(streamerId);
        Stream stream = database.getStreams().get(streamerId);
        database.getStreams().remove(streamId, stream);
        streamer.getStreams().remove(stream);
    }
}
