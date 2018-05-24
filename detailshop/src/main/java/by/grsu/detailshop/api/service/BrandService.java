package by.grsu.detailshop.api.service;

import by.grsu.detailshop.entity.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    public void addBrand(Brand brand);
    public void deleteBrand(Brand brand);
    public Optional<Brand> getById(Integer id);

    Brand getByName(String name);

    public List<Brand> getAllBrands();
}
