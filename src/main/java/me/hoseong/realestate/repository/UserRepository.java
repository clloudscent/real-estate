package me.hoseong.realestate.repository;

import me.hoseong.realestate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();
    User findById(String id);
    User findByEmail(String email);
    User findByIdAndPassword(String id, String password);
}
