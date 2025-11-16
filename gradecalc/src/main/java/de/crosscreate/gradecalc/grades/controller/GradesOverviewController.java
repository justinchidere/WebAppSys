package de.crosscreate.gradecalc.grades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.crosscreate.gradecalc.grades.service.GradesOverviewService;
import de.crosscreate.gradecalc.modules.model.Module;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class GradesOverviewController {
    
    @Autowired
    private GradesOverviewService gradesOverviewService; 

    @GetMapping("/")
    public String getGradesOverview(Model model) {
        model.addAttribute("studentName", "John Doe");
        model.addAttribute("modules", gradesOverviewService.getModules());
        model.addAttribute("averageGrade", gradesOverviewService.calculateGPA());
        return "overview.html";
    }

    public void addModule(String name, double grade, double credits) {
        gradesOverviewService.addModule(new Module(name, grade, credits));
    }

    // Show the add form via GET
    @GetMapping("/add")
    public String addModulePage(Model model) {
        model.addAttribute("studentName", "John Doe");
        return "add.html";
    }

    // Handle form submission via POST and redirect back to overview
    @PostMapping("/add")
    public String addModuleForm(@RequestParam String name, @RequestParam double grade, @RequestParam double credits) {
        gradesOverviewService.addModule(new Module(name, grade, credits));
        // Redirect so the browser navigates back to the overview page
        return "redirect:/";
    }

    public java.util.ArrayList<Module> getModules() {
        return gradesOverviewService.getModules();
    }

    public double getGPA() {
        return gradesOverviewService.calculateGPA();
    }
}
