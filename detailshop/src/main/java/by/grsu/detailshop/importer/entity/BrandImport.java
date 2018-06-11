package by.grsu.detailshop.importer.entity;

import by.grsu.detailshop.importer.entity.aentity.AEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BrandImport extends AEntity {
    String nameOfBrand;

    @XmlElement
    public String getNameOfBrand() {
        return nameOfBrand;
    }

    public void setNameOfBrand(String nameOfBrand) {
        this.nameOfBrand = nameOfBrand;
    }
}
