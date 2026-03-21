package com.capgemini.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.capgemini.training.entity.Employer;
import com.capgemini.training.entity.Job;
import com.capgemini.training.repository.EmployerRepository;
import com.capgemini.training.repository.JobRepository;          // ✅ ADD
import com.capgemini.training.repository.ApplicationRepository; // ✅ ADD
import com.capgemini.training.service.JobService;
import com.capgemini.training.service.ApplicationService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/employer")
public class EmployerController {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private JobService jobService;

    @Autowired
    private ApplicationService applicationService;

    // ✅ ADD THESE
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    // ✅ LOGIN (SESSION BASED)
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {

        Employer emp = employerRepository.findByEmail(email).orElse(null);

        if (emp != null && emp.getPassword().equals(password)) {
            session.setAttribute("employer", emp);
            return "redirect:/employer/dashboard";
        }

        model.addAttribute("error", "Invalid Credentials");
        return "login";
    }

    // ✅ DASHBOARD
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        Employer emp = (Employer) session.getAttribute("employer");

        if (emp == null) {
            return "redirect:/login?role=EMPLOYER";
        }

        model.addAttribute("user", emp);
        return "dashboard/employer-dashboard";
    }

    // ✅ SHOW POST JOB PAGE
    @GetMapping("/post-job")
    public String showPostJob(HttpSession session) {

        Employer emp = (Employer) session.getAttribute("employer");

        if (emp == null) {
            return "redirect:/login?role=EMPLOYER";
        }

        return "post-job";
    }

    // ✅ SAVE JOB
    @PostMapping("/save-job")
    public String saveJob(Job job, HttpSession session) {

        Employer emp = (Employer) session.getAttribute("employer");

        if (emp == null) {
            return "redirect:/login?role=EMPLOYER";
        }

        job.setEmployer(emp);
        jobService.saveJob(job);

        return "redirect:/employer/dashboard";
    }

    // ✅ VIEW MY JOBS
    @GetMapping("/my-jobs")
    public String myJobs(HttpSession session, Model model) {

        Employer emp = (Employer) session.getAttribute("employer");

        if (emp == null) {
            return "redirect:/login?role=EMPLOYER";
        }

        List<Job> jobs = jobService.getJobsByEmployer(emp.getId());
        model.addAttribute("jobs", jobs);

        return "employer-jobs";
    }

    // ✅ VIEW APPLICANTS
    @GetMapping("/applicants")
    public String viewApplicants(@RequestParam Long jobId,
                                 HttpSession session,
                                 Model model) {

        Employer emp = (Employer) session.getAttribute("employer");

        if (emp == null) {
            return "redirect:/login?role=EMPLOYER";
        }

        model.addAttribute("applications",
                applicationService.getByJob(jobId));

        return "view-applicants";
    }

    // ==============================
    // 🔥 NEW FEATURES START HERE
    // ==============================

    // ✅ EDIT EMPLOYER PROFILE
    @GetMapping("/edit")
    public String editProfile(HttpSession session, Model model) {

        Employer emp = (Employer) session.getAttribute("employer");

        if (emp == null) {
            return "redirect:/login?role=EMPLOYER";
        }

        model.addAttribute("employer", emp);
        return "edit-employer";
    }

    // ✅ UPDATE EMPLOYER PROFILE
    @PostMapping("/update")
    public String update(Employer emp, HttpSession session) {

        Employer updated = employerRepository.save(emp);

        // 🔥 update session
        session.setAttribute("employer", updated);

        return "redirect:/employer/dashboard";
    }

    // ✅ DELETE EMPLOYER (SAFE DELETE)
    @GetMapping("/delete")
    public String delete(HttpSession session) {

        Employer emp = (Employer) session.getAttribute("employer");

        if (emp == null) {
            return "redirect:/login?role=EMPLOYER";
        }

        Long empId = emp.getId();

        // 🔥 Step 1: get all jobs
        List<Job> jobs = jobRepository.findByEmployerId(empId);

        // 🔥 Step 2: delete applications of each job
        for (Job job : jobs) {
            applicationRepository.deleteByJobId(job.getId());
        }

        // 🔥 Step 3: delete jobs
        jobRepository.deleteAll(jobs);

        // 🔥 Step 4: delete employer
        employerRepository.deleteById(empId);

        // 🔥 Step 5: clear session
        session.invalidate();

        return "redirect:/login?role=EMPLOYER";
    }
}