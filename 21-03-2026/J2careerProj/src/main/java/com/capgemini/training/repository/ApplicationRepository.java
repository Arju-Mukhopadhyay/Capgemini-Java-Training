package com.capgemini.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;      // ✅ ADD
import org.springframework.transaction.annotation.Transactional; // ✅ ADD

import com.capgemini.training.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByJobId(Long jobId);

    List<Application> findByJobSeekerId(Long jobSeekerId);

    boolean existsByJobIdAndJobSeekerId(Long jobId, Long jobSeekerId);

    // ✅ FIXED METHOD
    @Modifying
    @Transactional
    void deleteByJobSeekerId(Long jobSeekerId);
    
    
    @Modifying
    @Transactional
    void deleteByJobId(Long jobId);
    
    
    
    
}