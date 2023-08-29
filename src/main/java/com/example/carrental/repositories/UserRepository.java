package com.example.carrental.repositories;

import com.example.carrental.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    User findById(long id);
}