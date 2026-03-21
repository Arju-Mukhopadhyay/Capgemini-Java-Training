package com.capgemini.training.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.training.entity.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long> {

    Optional<Employer> findByEmail(String email);
}