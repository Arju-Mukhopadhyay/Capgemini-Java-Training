package com.capgemini.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.training.entity.Job;
import com.capgemini.training.service.JobService;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    // ✅ View all jobs (with userId)
    @GetMapping("/jobs")
    public String viewJobs(Model model,
                           @RequestParam Long userId) {

        List<Job> jobs = jobService.getAllJobs();
        model.addAttribute("jobs", jobs);

        // ✅ VERY IMPORTANT (for Apply button)
        model.addAttribute("userId", userId);

        return "jobs"; // loads jobs.jsp
    }
}