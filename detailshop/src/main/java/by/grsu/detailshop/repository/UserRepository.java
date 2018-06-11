package by.grsu.detailshop.repository;

import by.grsu.detailshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{
    User findByUsername(String username);
}
