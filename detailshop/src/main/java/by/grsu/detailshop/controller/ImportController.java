package by.grsu.detailshop.controller;

import by.grsu.detailshop.entity.Brand;
import by.grsu.detailshop.entity.Model;
import by.grsu.detailshop.imorter.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/autoparts")
public class ImportController {

    @Autowired
    ImportService importService;


    @GetMapping(path ="/import")
    public void importToDb() throws IOException, JAXBException {
        importService.importToDb();
    }

}
