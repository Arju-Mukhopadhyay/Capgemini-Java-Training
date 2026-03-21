package com.capgemini.training.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.training.entity.Application;
import com.capgemini.training.entity.Job;
import com.capgemini.training.entity.JobSeeker;
import com.capgemini.training.repository.ApplicationRepository;
import com.capgemini.training.repository.JobRepository;
import com.capgemini.training.repository.JobSeekerRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public String applyJob(Long jobId, Long jobSeekerId) {

        if (applicationRepository.existsByJobIdAndJobSeekerId(jobId, jobSeekerId)) {
            return "exists"; // 👈 important
        }

        Job job = jobRepository.findById(jobId).orElseThrow();
        JobSeeker js = jobSeekerRepository.findById(jobSeekerId).orElseThrow();

        Application app = new Application();
        app.setJob(job);
        app.setJobSeeker(js);
        app.setAppliedDate(LocalDate.now());
        app.setStatus("APPLIED");

        applicationRepository.save(app);

        return "applied"; // 👈 important
    }

    public List<Application> getByJob(Long jobId) {
        return applicationRepository.findByJobId(jobId);
    }

    public List<Application> getByJobSeeker(Long id) {
        return applicationRepository.findByJobSeekerId(id);
    }
}