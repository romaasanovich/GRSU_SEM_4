package by.grsu.detailshop.entity;

import by.grsu.detailshop.entity.aentity.AEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`orderhistory`")
public class Order extends AEntity {
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @ManyToMany(cascade = CascadeType.ALL)    @JoinTable(name = "orderHistory", joinColumns = { @JoinColumn(name = "userId")}, inverseJoinColumns = { @JoinColumn(name = "detailId") })
    private List<Detail> details;
    @Column(name = "deliveryTime")
    private Integer deliveryTime;
    @Column(name = "count")
    private Integer count;

        public Order() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
