package Commands;

import Database.Database;
import Streams.Stream;

public class AddCommand extends Command{
    @Override
    public void execute(String data, Database database) {
        String[] info = data.split(" ", 7);

        int streamerId = Integer.parseInt(info[0]);
        int streamType = Integer.parseInt(info[2]);
        int id = Integer.parseInt(info[3]);
        int streamGenre = Integer.parseInt(info[4]);
        long length = Long.parseLong(info[5]);
        String name = info[6];

        Stream stream = new Stream(streamType, id, streamGenre, 0, streamerId, length, 0, name);
        database.getStreams().put(id, stream);
        database.getStreamers().get(streamerId).getStreams().add(stream);
    }
}
