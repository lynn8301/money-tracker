package com.example.moneytracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.moneytracker.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findAll();
    Optional<User> findById(Long id);

    @Modifying
    @Query("delete from User where id = :id")
    void deleteById(@Param("id") Long id);
}
