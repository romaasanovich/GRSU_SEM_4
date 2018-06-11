package by.grsu.detailshop.importer.entity.aentity;

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
