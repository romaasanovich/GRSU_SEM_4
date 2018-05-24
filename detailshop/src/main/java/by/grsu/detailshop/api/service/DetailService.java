package by.grsu.detailshop.api.service;

import by.grsu.detailshop.entity.Car;
import by.grsu.detailshop.entity.Detail;

import java.util.List;
import java.util.Optional;

public interface DetailService {
    public void deleteDetail(Detail detail);
    public Optional<Detail> getById(Integer id);
    public List<Detail> getAllDetails();
    public void addDetail(Detail detail);

    List<Detail> getCarDetails(Car car);
}
