package by.grsu.detailshop.utills;

import by.grsu.detailshop.imorter.repo.ImportEntityRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

public class Converter {

    public ImportEntityRepository fromJsonToEntityRep(String jsonLine) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ImportEntityRepository importEntityRepository = mapper.readValue(jsonLine, ImportEntityRepository.class);
        return importEntityRepository;
    }

    public ImportEntityRepository fromXmlToEntityRep(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ImportEntityRepository.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ImportEntityRepository importEntityRepository = (ImportEntityRepository) jaxbUnmarshaller.unmarshal(file);
        return importEntityRepository;
    }

    public String test(ImportEntityRepository repo) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ImportEntityRepository.class);
        Marshaller jaxbUnmarshaller = jaxbContext.createMarshaller();
        jaxbUnmarshaller.marshal(repo,System.out);
        return "";
    }


}
