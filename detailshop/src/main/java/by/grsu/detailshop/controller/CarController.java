package by.grsu.detailshop.controller;

import by.grsu.detailshop.api.service.CarService;
import by.grsu.detailshop.api.service.ModelService;
import by.grsu.detailshop.entity.Car;
import by.grsu.detailshop.entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/autoparts")
public class CarController {
    @Autowired
    CarService carService;
    @Autowired
    ModelService modelService;

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping(path ="/cars/model/{modelId}")
    public List<Car> getModifications(@PathVariable(name = "modelId") Integer id){
        Model model = modelService.getById(id).get();
        return carService.getModelCars(model);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping(path ="/cars/{modelId}")
    public Car getModification(@PathVariable(name = "modelId") Integer id){
        return carService.getById(id).get();
    }
}
