package by.grsu.detailshop.api.service;

import by.grsu.detailshop.entity.Brand;
import by.grsu.detailshop.entity.Model;

import java.util.List;
import java.util.Optional;

public interface ModelService {
    public void addModel(Model model);
    public void deleteModel(Model model);
    public Optional<Model> getById(Integer id);
    public List<Model> getAllModels();
    public List<Model> getBrandModels(Brand brand);
}
