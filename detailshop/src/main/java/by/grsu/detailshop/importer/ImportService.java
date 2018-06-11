package by.grsu.detailshop.importer;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface ImportService {
    public void importToDb() throws IOException, JAXBException;
}
