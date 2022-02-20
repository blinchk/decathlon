package ee.laus.decathlon.io.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;

public interface FileReader<T> {
    Collection<T> read(File file) throws FileNotFoundException;
}
