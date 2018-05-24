package by.grsu.detailshop.api.service;

import by.grsu.detailshop.entity.Seller;

import java.util.List;
import java.util.Optional;

public interface SellerService {
    public void addSeller(Seller seller);
    public void deleteSeller(Seller seller);
    public void updateSeller(Seller seller);
    public Optional<Seller> getById(Integer id);
    public List<Seller> getAllSellers();
}
