package ee.laus.decathlon.io.writer;

import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLWriter implements FileWriter {
    private final Document document;
    private Transformer transformer;

    public XMLWriter(Document document) {
        this.document = document;
    }

    @Override
    public void write(String path) {
        this.transformer = createTransformer();
        DOMSource source = new DOMSource(document);
        File file = new File(path);
        StreamResult result = new StreamResult(file);
        transform(source, result);
    }

    private Transformer createTransformer() {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            return transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void transform(DOMSource source, StreamResult result) {
        try {
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
