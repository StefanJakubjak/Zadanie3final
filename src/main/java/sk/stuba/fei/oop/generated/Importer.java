package sk.stuba.fei.oop.generated;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Importer {


    public Document importFile( String path) throws JAXBException, FileNotFoundException {
        FileInputStream stream=new FileInputStream(path);
        JAXBContext context=JAXBContext.newInstance(Document.class);
        Unmarshaller unmarshaller= context.createUnmarshaller();

        return (Document) unmarshaller.unmarshal(stream);
    }
}
