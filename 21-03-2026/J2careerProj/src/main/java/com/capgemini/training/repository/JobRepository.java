package com.capgemini.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.training.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByLocationContaining(String location);

    // ✅ Only ONE method
    List<Job> findByEmployerId(Long employerId);
}