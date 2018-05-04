package com.example.demo.repository;

import com.example.demo.domain.Girlaaa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girlaaa, Integer> {
    public List<Girlaaa> findByAge(Integer age);
}
