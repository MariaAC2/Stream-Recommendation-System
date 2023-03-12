package Users;

import Database.Database;
import Streams.Stream;

import java.util.HashMap;
import java.util.List;

public class User {
    private int id;
    private String name;
    private List<Stream> streams;

    public User(int id, String name, List<Stream> streams) {
        this.id = id;
        this.name = name;
        this.streams = streams;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stream> getStreams() {
        return streams;
    }

    public void setStreams(List<Stream> streams) {
        this.streams = streams;
    }
}
