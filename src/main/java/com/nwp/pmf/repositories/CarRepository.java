package com.nwp.pmf.repositories;

import com.nwp.pmf.dto.CarDTO;
import com.nwp.pmf.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByUserId(Long id);

    List<Car> findAllByNameContainingIgnoreCase(String name);
}
