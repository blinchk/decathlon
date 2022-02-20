package ee.laus.decathlon.common;

import java.io.File;
import java.net.URL;
import java.util.Objects;

public class ResourceLoader {
    public File loadByFileName(final String fileName) {
        URL url = getClass()
                .getClassLoader()
                .getResource(fileName);

        String path = Objects.requireNonNull(url).getFile();
        return new File(path);
    }
}
