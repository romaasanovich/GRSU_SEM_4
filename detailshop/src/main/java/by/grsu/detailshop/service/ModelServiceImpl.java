package by.grsu.detailshop.service;

import by.grsu.detailshop.api.service.ModelService;
import by.grsu.detailshop.entity.Brand;
import by.grsu.detailshop.entity.Model;
import by.grsu.detailshop.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ModelServiceImpl implements ModelService {
    @Autowired
    ModelRepository modelRepository;

    @Override
    public void addModel(Model model) {
        modelRepository.save(model);
    }

    @Override
    public void deleteModel(Model model) {
        modelRepository.delete(model);
    }

    @Override
    public Optional<Model> getById(Integer id) {
        return modelRepository.findById(id);
    }

    @Override
    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    @Override
    public List<Model> getBrandModels(Brand brand) {
        List<Model> allModels=modelRepository.findAll();
        List<Model> brandModels= new ArrayList<>();
        for (Model model:allModels) {
            if(model.getBrand().getNameOfBrand().equals(brand.getNameOfBrand())){
                brandModels.add(model);
            }
        }
        return brandModels;
    }
}
