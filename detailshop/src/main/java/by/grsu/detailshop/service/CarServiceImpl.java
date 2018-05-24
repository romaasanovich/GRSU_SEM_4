package by.grsu.detailshop.service;

import by.grsu.detailshop.api.service.CarService;
import by.grsu.detailshop.entity.Car;
import by.grsu.detailshop.entity.Model;
import by.grsu.detailshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepository carRepository;

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void deleteCar(Car car) {
        carRepository.delete(car);
    }

    @Override
    public Optional<Car> getById(Integer id) {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getModelCars(Model model) {
        List<Car> allModifications = carRepository.findAll();
        List<Car> modelModifications = new ArrayList<>();
        for (Car car : allModifications) {
            if (car.getModel().getId() == model.getId()) {
                modelModifications.add(car);
            }
        }
        return modelModifications;
    }
}
