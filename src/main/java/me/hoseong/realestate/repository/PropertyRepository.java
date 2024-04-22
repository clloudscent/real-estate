package me.hoseong.realestate.repository;

import me.hoseong.realestate.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
    List<Property> findAll();

    Property findById(int id);
}
