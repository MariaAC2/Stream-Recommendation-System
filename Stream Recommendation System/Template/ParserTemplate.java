package Template;

import Database.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public abstract class ParserTemplate {
    protected String filename;

    public ParserTemplate(String filename) {
        this.filename = filename;
    }

    public List<String> getData() {
        List<String> list = new LinkedList<>();
        try (FileReader fileReader = new FileReader(filename);
             BufferedReader objReader = new BufferedReader(fileReader)){
            String line;
            while ((line = objReader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public abstract void processData(Database database);
}
