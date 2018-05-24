package by.grsu.detailshop.repository;

import by.grsu.detailshop.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

    @Query("select b from Brand b where b.nameOfBrand = :name")
    Brand findByName(@Param("name") String name);
}
