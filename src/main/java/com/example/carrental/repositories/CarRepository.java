package com.example.carrental.repositories;

import com.example.carrental.domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    Car findById(long id);

    List<Car> findAll();
}