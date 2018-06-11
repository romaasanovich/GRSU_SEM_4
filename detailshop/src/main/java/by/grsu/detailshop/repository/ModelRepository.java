package by.grsu.detailshop.repository;

import by.grsu.detailshop.entity.Brand;
import by.grsu.detailshop.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Integer> {

}
