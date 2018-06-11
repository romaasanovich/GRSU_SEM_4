package by.grsu.detailshop.controller;

import by.grsu.detailshop.api.service.CarService;
import by.grsu.detailshop.api.service.DetailService;
import by.grsu.detailshop.entity.Detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/autoparts")
public class DetailController {

    @Autowired
    CarService carService;
    @Autowired
    DetailService detailService;

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping(path ="/details")
    public List<Detail> getAllDetails(){
        return detailService.getAllDetails();
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping(path ="/details/{carId}")
    public List<Detail> getCarDetails(@PathVariable(name = "carId") Integer id){
        return detailService.getCarDetails(carService.getById(id).get());
    }
}
