package by.grsu.detailshop.service;

import by.grsu.detailshop.api.service.BrandService;
import by.grsu.detailshop.entity.Brand;
import by.grsu.detailshop.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepository brandRepository;

    @Override
    public void addBrand(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(Brand brand) {
        brandRepository.delete(brand);
    }

    @Override
    public Optional<Brand> getById(Integer id) {
        return brandRepository.findById(id);
    }

    @Override
    public Brand getByName(String name) {
        return brandRepository.findByName(name);
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }
}
