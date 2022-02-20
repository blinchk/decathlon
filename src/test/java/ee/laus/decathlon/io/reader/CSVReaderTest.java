package ee.laus.decathlon.io.reader;

import ee.laus.decathlon.common.ResourceLoader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CSVReaderTest {

    @Test
    void read_Test() throws FileNotFoundException {
        ResourceLoader loader = new ResourceLoader();
        File file = loader.loadByFileName("results.csv");
        FileReader<String[]> reader = new CSVReader();
        Collection<String[]> result = reader.read(file);
        Long expectedLength = 5L;
        assertEquals(expectedLength, result.size());
    }
}