package by.grsu.detailshop.imorter.entity;

import by.grsu.detailshop.imorter.entity.aentity.AEntity;

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
