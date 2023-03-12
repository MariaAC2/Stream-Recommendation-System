package Streams;

import Database.Database;
import Streamers.Streamer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.TimeZone;

public class Stream {
    private int streamType;
    private int id;
    private int streamGenre;
    private long noOfStreams;
    private int streamerId;
    private long length;
    private long dateAdded;
    private String name;

    public Stream(int streamType, int id,
                  int streamGenre, long noOfStreams,
                  int streamerId, long length,
                  long dateAdded, String name) {
        this.streamType = streamType;
        this.id = id;
        this.streamGenre = streamGenre;
        this.noOfStreams = noOfStreams;
        this.streamerId = streamerId;
        this.length = length;
        this.dateAdded = dateAdded;
        this.name = name;
    }

    public int getStreamType() {
        return streamType;
    }

    public void setStreamType(int streamType) {
        this.streamType = streamType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStreamGenre() {
        return streamGenre;
    }

    public void setStreamGenre(int streamGenre) {
        this.streamGenre = streamGenre;
    }

    public long getNoOfStreams() {
        return noOfStreams;
    }

    public void setNoOfStreams(long noOfStreams) {
        this.noOfStreams = noOfStreams;
    }

    public int getStreamerId() {
        return streamerId;
    }

    public void setStreamerId(int streamerId) {
        this.streamerId = streamerId;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public long getDayAdded() {
        return dateAdded;
    }

    public void setDateAdded(long dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreamerName(Database database) {
        Streamer streamer = database.getStreamers().get(streamerId);
        return streamer.getName();
    }

    public String getDay() {
        Date date = new Date(this.dateAdded * 1000L);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        String dateText = format.format(date);
        return dateText;
    }

    public Date getDate() throws ParseException {
        String day = getDay();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.parse(day);
    }

    public String getTime() {
        int seconds = (int) this.length % 60 ;
        int minutes = (int) ((this.length / 60) % 60);
        int hours   = (int) (this.length / (60 * 60));

        String timeText;
        if (hours == 0) {
            timeText = String.format("%02d:%02d", minutes, seconds);
        } else {
            timeText = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        }

        return timeText;
    }

    public void addNoOfStreams() {
        this.noOfStreams++;
    }

    public String print(Database database) {
        return "{" +
                "\"id\":\"" + id + "\"," +
                "\"name\":\"" + name + "\"," +
                "\"streamerName\":\"" + this.getStreamerName(database) + "\"," +
                "\"noOfListenings\":\"" + noOfStreams + "\"," +
                "\"length\":\"" + this.getTime() + "\"," +
                "\"dateAdded\":\"" + this.getDay() + "\"" +
                "}";
    }
}
