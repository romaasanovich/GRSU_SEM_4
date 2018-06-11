package by.grsu.detailshop.api.service;

import by.grsu.detailshop.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public void addOrder(Order Order);
    public void deleteOrder(Order Order);
    public Optional<Order> getById(Integer id);
    public List<Order> getAllOrders();
}
