package com.capgemini.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.training.entity.Employer;
import com.capgemini.training.repository.EmployerRepository;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    public Employer register(Employer employer) {
        return employerRepository.save(employer);
    }

    public Employer login(String email, String password) {
        Employer emp = employerRepository.findByEmail(email).orElse(null);

        if (emp != null && emp.getPassword().equals(password)) {
            return emp;
        }

        return null;
    }
}