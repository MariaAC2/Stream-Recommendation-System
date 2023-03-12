package Streams;

import java.text.ParseException;
import java.util.Comparator;

public class SurpriseStream implements Comparator<Stream> {
    @Override
    public int compare(Stream o1, Stream o2) {
        try {
            if (o1.getDate().compareTo(o2.getDate()) < 0) {
                return 1;
            } else if (o1.getDate().compareTo(o2.getDate()) == 0) {
                return Long.compare(o2.getNoOfStreams(), o1.getNoOfStreams());
            }
            return -1;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
