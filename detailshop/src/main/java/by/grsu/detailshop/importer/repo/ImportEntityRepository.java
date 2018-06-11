package by.grsu.detailshop.importer.repo;

import by.grsu.detailshop.importer.entity.BrandImport;
import by.grsu.detailshop.importer.entity.CarImport;
import by.grsu.detailshop.importer.entity.DetailImport;
import by.grsu.detailshop.importer.entity.ModelImport;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name ="entities")
public class ImportEntityRepository {
    private List<BrandImport> brands;
    private List<CarImport> cars;
    private List<ModelImport> models;
    private List<DetailImport> details;

    @XmlElementWrapper(name="brands")
    @XmlElement(name="brand")
    public List<BrandImport> getBrands() {
        return brands;
    }

    public void setBrands(List<BrandImport> brands) {
        this.brands = brands;
    }

    @XmlElementWrapper(name="cars")
    @XmlElement(name="car")
    public List<CarImport> getCars() {
        return cars;
    }

    public void setCars(List<CarImport> cars) {
        this.cars = cars;
    }

    @XmlElementWrapper(name="models")
    @XmlElement(name="model")
    public List<ModelImport> getModels() {
        return models;
    }

    public void setModels(List<ModelImport> models) {
        this.models = models;
    }
    @XmlElementWrapper(name="details")
    @XmlElement(name="detail")
    public List<DetailImport> getDetails() {
        return details;
    }

    public void setDetails(List<DetailImport> details) {
        this.details = details;
    }
}
