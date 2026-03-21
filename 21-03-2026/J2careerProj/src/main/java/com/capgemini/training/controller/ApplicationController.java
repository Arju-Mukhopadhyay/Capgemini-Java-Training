package com.capgemini.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.capgemini.training.service.ApplicationService;

@Controller
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/apply")
    public String apply(@RequestParam Long jobId,
                        @RequestParam Long jobSeekerId) {

        String result = applicationService.applyJob(jobId, jobSeekerId);

        return "redirect:/jobs?userId=" + jobSeekerId + "&msg=" + result;
    }
}