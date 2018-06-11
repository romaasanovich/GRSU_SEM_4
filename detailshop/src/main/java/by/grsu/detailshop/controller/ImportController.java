package by.grsu.detailshop.controller;

import by.grsu.detailshop.importer.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@RestController
@RequestMapping(path = "/autoparts")
public class ImportController {

    @Autowired
    ImportService importService;

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping(path ="/import")
    public void importToDb() throws IOException, JAXBException {
        importService.importToDb();
    }

}
