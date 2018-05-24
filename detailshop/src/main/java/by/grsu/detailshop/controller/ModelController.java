package by.grsu.detailshop.controller;

import by.grsu.detailshop.api.service.BrandService;
import by.grsu.detailshop.api.service.ModelService;
import by.grsu.detailshop.entity.Brand;
import by.grsu.detailshop.entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/autoparts")
public class ModelController {
    @Autowired
    BrandService brandService;
    @Autowired
    ModelService modelService;


    @GetMapping(path ="/models/{brandName}")
    public List<Model> getModels(@PathVariable(name = "brandName") String brandName){
        Brand brand = brandService.getByName(brandName);
        return modelService.getBrandModels(brand);
    }

    @GetMapping(path ="/models/{id}")
    public List<Model> getModels(@PathVariable(name = "id") Integer id){
        Brand brand = brandService.getById(id).get();
        return modelService.getBrandModels(brand);
    }

}
