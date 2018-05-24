package by.grsu.detailshop.api.service;

import by.grsu.detailshop.entity.Car;
import by.grsu.detailshop.entity.Model;

import java.util.List;
import java.util.Optional;

public interface CarService {
    public void addCar(Car car);
    public void deleteCar(Car car);
    public Optional<Car> getById(Integer id);
    public List<Car> getAllCars();

    List<Car> getModelCars(Model model);
}
