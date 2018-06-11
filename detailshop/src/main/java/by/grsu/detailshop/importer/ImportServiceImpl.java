package by.grsu.detailshop.importer;

import by.grsu.detailshop.api.service.BrandService;
import by.grsu.detailshop.api.service.CarService;
import by.grsu.detailshop.api.service.ModelService;
import by.grsu.detailshop.entity.Brand;
import by.grsu.detailshop.entity.Car;
import by.grsu.detailshop.entity.Detail;
import by.grsu.detailshop.entity.Model;
import by.grsu.detailshop.importer.entity.BrandImport;
import by.grsu.detailshop.importer.entity.CarImport;
import by.grsu.detailshop.importer.entity.DetailImport;
import by.grsu.detailshop.importer.entity.ModelImport;
import by.grsu.detailshop.importer.repo.ImportEntityRepository;
import by.grsu.detailshop.utills.Converter;
import by.grsu.detailshop.utills.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@Service
public class ImportServiceImpl implements ImportService {

    @Autowired
    BrandService brandService;
    @Autowired
    ModelService modelService;
    @Autowired
    CarService carService;


    @Override
    public void importToDb() throws IOException, JAXBException {
        Converter converter = new Converter();
        ImportEntityRepository importEntityRepository = converter.fromXmlToEntityRep(new Reader().getFile("entity.xml"));

        importBrands(importEntityRepository.getBrands());
        importModels(importEntityRepository.getModels());
        importCars(importEntityRepository.getCars());
        importDetails(importEntityRepository.getDetails());
    }


    private  void importModels(List<ModelImport> models){
        for (ModelImport modelImport:models) {
            Model model = new Model();
            model.setId(modelImport.getId());
            model.setBrand(brandService.getById(modelImport.getBrandId()).get());
            model.setModel(modelImport.getModel());
            model.setYearOfRelease(modelImport.getYearOfRelease());
            modelService.addModel(model);
        }
    }

    private  void importBrands(List<BrandImport> brands){
        for (BrandImport brandImport:brands) {
            Brand brand = new Brand();
            brand.setId(brand.getId());
            brand.setNameOfBrand(brand.getNameOfBrand());
            brandService.addBrand(brand);
        }
    }

    private  void importCars(List<CarImport> cars){
        for (CarImport carImport:cars) {
            Car car = new Car();
            car.setId(carImport.getId());
            car.setEngine(carImport.getEngine());
            car.setFuel(carImport.getFuel());
            car.setModel(modelService.getById(carImport.getId()).get());
            car.setWheelDrive(carImport.getWheelDrive());
            carService.addCar(car);
        }
    }

    private  void importDetails(List<DetailImport> detailImports){
        for (DetailImport detailImport:detailImports) {
            Detail detail = new Detail();
            detail.setId(detailImport.getId());
            detail.setArticleCode(detailImport.getArticleCode());
            detail.setCar(carService.getById(detailImport.getCarId()).get());
            detail.setDelieryPeriod(detailImport.getDelieryPeriod());
            detail.setDescription(detailImport.getDescription());
            detail.setPrice(detailImport.getPrice());
            detail.setWeight(detailImport.getWeight());
        }
    }

}






//        for (Brand brand:brandService.getAllBrands()) {
//            BrandImport brandImport = new BrandImport();
//            brandImport.setId(brand.getId());
//            brandImport.setNameOfBrand(brand.getNameOfBrand());
//            brandImportList.add(brandImport);
//        }
//        importEntityRepository.setBrands(brandImportList);

//        for (Model model:modelService.getAllModels()) {
//            ModelImport modelImport = new ModelImport();
//            modelImport.setId(model.getId());
//            modelImport.setBrandId(model.getBrand().getId());
//            modelImport.setModel(model.getModel());
//            modelImport.setYearOfRelease(model.getYearOfRelease());
//            modelImports.add(modelImport);
//        }
//        importEntityRepository.setModels(modelImports);

//        for (Car car:carService.getAllCars()) {
//            CarImport carImport = new CarImport();
//            carImport.setId(car.getId());
//            carImport.setEngine(car.getEngine());
//            carImport.setFuel(car.getFuel());
//            carImport.setModelId(car.getModel().getId());
//            carImport.setWheelDrive(car.getWheelDrive());
//            carImports.add(carImport);
//        }
//        importEntityRepository.setCars(carImports);
//        Converter converter = new Converter();
//        try {
//            converter.test(importEntityRepository);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
