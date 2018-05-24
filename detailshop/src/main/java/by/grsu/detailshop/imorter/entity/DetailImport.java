package by.grsu.detailshop.imorter.entity;

import by.grsu.detailshop.imorter.entity.aentity.AEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DetailImport extends AEntity {
    private Integer carId;
    private Integer articleCode;
    private String description;
    private Integer deliveryPeriod;
    private double weight;
    private double price;

    public DetailImport() {
    }

    @XmlElement
    public Integer getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(Integer articleCode) {
        this.articleCode = articleCode;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement
    public Integer getDelieryPeriod() {
        return deliveryPeriod;
    }

    public void setDelieryPeriod(Integer delieryPeriod) {
        this.deliveryPeriod = delieryPeriod;
    }

    @XmlElement
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @XmlElement
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlElement
    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    @XmlElement
    public Integer getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public void setDeliveryPeriod(Integer deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
    }
}
