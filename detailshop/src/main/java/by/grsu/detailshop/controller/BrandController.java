package by.grsu.detailshop.controller;

import by.grsu.detailshop.api.service.BrandService;
import by.grsu.detailshop.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/autoparts")
public class BrandController {
    @Autowired
    BrandService brandService;

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping(path ="/brands")
    public List<Brand> getAllBrands(){
        return brandService.getAllBrands();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path ="/brand/{name}")
    public void addBrand(@PathVariable(name = "name") String name){
        Brand brand = new Brand();
        brand.setNameOfBrand(name);
        brandService.addBrand(brand);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path ="/brand/{id}")
    public void deleteBrand(@PathVariable(name = "id") Integer id){
        Brand brand = brandService.getById(id).get();
        brandService.deleteBrand(brand);
    }
}
