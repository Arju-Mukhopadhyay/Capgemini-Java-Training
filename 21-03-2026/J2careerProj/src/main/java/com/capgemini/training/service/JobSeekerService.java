package com.capgemini.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.training.entity.JobSeeker;
import com.capgemini.training.repository.JobSeekerRepository;

@Service
public class JobSeekerService {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public JobSeeker register(JobSeeker js) {
        return jobSeekerRepository.save(js);
    }
   
    public JobSeeker update(JobSeeker js) {
        return jobSeekerRepository.save(js);
    }
    
    public JobSeeker login(String email, String password) {
        JobSeeker js = jobSeekerRepository.findByEmail(email).orElse(null);

        if (js != null && js.getPassword().equals(password)) {
            return js;
        }

        return null;
    }
}