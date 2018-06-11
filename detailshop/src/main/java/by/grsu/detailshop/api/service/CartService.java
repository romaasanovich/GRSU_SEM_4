package by.grsu.detailshop.api.service;

import by.grsu.detailshop.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    public void addCart(Cart cart);
    public void deleteCart(Cart cart);
    public void updateCart(Cart cart);
    public Optional<Cart> getById(Integer id);
    public List<Cart> getAllCarts();
}
