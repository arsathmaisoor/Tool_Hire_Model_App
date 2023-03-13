package src;

import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {
    private FileWriter writer;

    public DataWriter(String filename) throws IOException {
        writer = new FileWriter(filename);
    }

    public void writeData(String data) throws IOException {
        writer.write(data);
    }

    public void close() throws IOException {
        writer.close();
    }
}
