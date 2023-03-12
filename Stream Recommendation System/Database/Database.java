package Database;

import Streamers.Streamer;
import Streams.RecommendStream;
import Streams.Stream;
import Streams.SurpriseStream;
import Users.User;
import java.util.*;

public class Database {
    private static Database dbInstance;
    private HashMap<Integer, Streamer> streamers = new HashMap<>();
    private HashMap<Integer, Stream> streams = new HashMap<>();
    private HashMap<Integer, User> users = new HashMap<>();

    private Database() {}

    public static Database getDbInstance() {
        if (dbInstance == null) {
            return new Database();
        }

        return dbInstance;
    }

    public HashMap<Integer, Streamer> getStreamers() {
        return streamers;
    }

    public void setStreamers(HashMap<Integer, Streamer> streamers) {
        this.streamers = streamers;
    }

    public HashMap<Integer, Stream> getStreams() {
        return streams;
    }

    public void setStreams(HashMap<Integer, Stream> streams) {
        this.streams = streams;
    }

    public HashMap<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<Integer, User> users) {
        this.users = users;
    }

    public List<Stream> getRecommendation(int userId, int streamType) {
        List<Stream> list = new ArrayList<>(streams.values());
        User user = users.get(userId);

        for (Stream stream: user.getStreams()) {
            for (Stream s: streams.values()) {
                if (s.getStreamType() != streamType ||
                        s.getStreamerId() != stream.getStreamerId() ||
                        s.getId() == stream.getId()) {
                    list.remove(s);
                }
            }
        }

        RecommendStream rcomp = new RecommendStream();
        Collections.sort(list, rcomp);

        if (list.size() > 5) {
            list = list.subList(0, 5);
        }
        return list;
    }

    public List<Stream> getSurprise(int userId, int streamType) {
        List<Stream> list = new ArrayList<Stream>(streams.values());
        User user = users.get(userId);

        for (Stream stream: user.getStreams()) {
            for (Stream s: streams.values()) {
                if (s.getStreamType() != streamType ||
                        s.getStreamerId() == stream.getStreamerId()) {
                    list.remove(s);
                }
            }
        }

        SurpriseStream scomp = new SurpriseStream();
        Collections.sort(list, scomp);

        if (list.size() > 3) {
            list = list.subList(0, 3);
        }
        return list;
    }

    public String print(List<Stream> list) {
        String x = "[";
        for (int i = 0; i < list.size(); i++) {
            Stream stream = list.get(i);
            x += stream.print(this);

            if (i < list.size() - 1) {
                x += ",";
            }
        }
        x += "]";

        return x;
    }
}
