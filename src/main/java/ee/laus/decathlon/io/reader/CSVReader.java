package ee.laus.decathlon.io.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CSVReader implements FileReader<String[]> {
    private String delimiter = ";";

    public CSVReader() {}

    public CSVReader(String delimiter) {
        this.delimiter = delimiter;
    }

    public Collection<String[]> read(File file) throws FileNotFoundException {
        List<String[]> content = new ArrayList<>();
        Path path = Path.of(file.toURI());
        try {
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String line = reader.readLine();
            while (line != null) {
                String[] row = line.split(delimiter);
                if (line.length() > 1) content.add(row);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
