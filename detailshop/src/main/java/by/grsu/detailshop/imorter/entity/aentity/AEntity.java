package by.grsu.detailshop.imorter.entity.aentity;

import javax.persistence.*;

public abstract class AEntity {
    private Integer id;

    protected AEntity() {
    }

    public AEntity(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

}
