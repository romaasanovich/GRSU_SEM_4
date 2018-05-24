package by.grsu.detailshop.service;

import by.grsu.detailshop.api.service.DetailService;
import by.grsu.detailshop.entity.Car;
import by.grsu.detailshop.entity.Detail;
import by.grsu.detailshop.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DetailServiceImpl implements DetailService {
    @Autowired
    DetailRepository detailRepository;

    @Override
    public void addDetail(Detail detail) {
        detailRepository.save(detail);
    }

    @Override
    public void deleteDetail(Detail detail) {
        detailRepository.delete(detail);
    }

    @Override
    public Optional<Detail> getById(Integer id) {
        return detailRepository.findById(id);
    }

    @Override
    public List<Detail> getAllDetails() {
        return detailRepository.findAll();
    }


    @Override
    public List<Detail> getCarDetails(Car car){
        List<Detail> allDetails = detailRepository.findAll();
        List<Detail> carDetails = new ArrayList<>();
        for (Detail detail:allDetails) {
            if(detail.getCar().getId() == car.getId()){
                carDetails.add(detail);
            }
        }
        return carDetails;
    }
}
