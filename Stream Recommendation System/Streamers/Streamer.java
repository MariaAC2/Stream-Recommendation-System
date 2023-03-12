package Streamers;

import Database.Database;
import Streams.Stream;

import java.util.ArrayList;
import java.util.List;

public class Streamer {
    private int streamerType;
    private int id;
    private String name;
    private List<Stream> streams = new ArrayList<>();

    public Streamer(int streamerType, int id, String name) {
        this.streamerType = streamerType;
        this.id = id;
        this.name = name;
    }

    public int getStreamerType() {
        return streamerType;
    }

    public void setStreamerType(int streamerType) {
        this.streamerType = streamerType;
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
