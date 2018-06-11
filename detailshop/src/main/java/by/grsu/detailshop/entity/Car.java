package by.grsu.detailshop.entity;

import by.grsu.detailshop.entity.aentity.AEntity;
import by.grsu.detailshop.entity.enums.WheelDrive;

import javax.persistence.*;

@Entity
@Table(name = "`modification`")
public class Car extends AEntity {
    @ManyToOne
    @JoinColumn(name = "modelId")
    Model model;
    @Column(name = "fuel",length = 45)
    String fuel;
    @Column(name = "engine",length = 45)
    String engine;
    @Column(name = "wheelDrive",length = 45)
    String wheelDrive;

    public Car(Integer id, Model model, String fuel, String engine, String wheelDrive) {
        super(id);
        this.model = model;
        this.fuel = fuel;
        this.engine = engine;
        this.wheelDrive = wheelDrive;
    }

    public Car() {
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getWheelDrive() {
        return wheelDrive;
    }

    public void setWheelDrive(String wheelDrive) {
        this.wheelDrive = wheelDrive;
    }
}
