package Streams;

import java.util.Comparator;

public class RecommendStream implements Comparator<Stream> {
    @Override
    public int compare(Stream o1, Stream o2) {
        return Long.compare(o1.getNoOfStreams(), o2.getNoOfStreams());
    }
}
