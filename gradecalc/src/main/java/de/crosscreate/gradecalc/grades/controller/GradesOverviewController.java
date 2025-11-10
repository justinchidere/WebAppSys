package de.crosscreate.gradecalc.grades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.crosscreate.gradecalc.grades.service.GradesOverviewService;
import de.crosscreate.gradecalc.modules.model.Module;

@Controller
public class GradesOverviewController {
    @Autowired
    private GradesOverviewService gradesOverviewService;

    public void addModule(String name, double grade, double credits) {
        gradesOverviewService.addModule(new Module(name, grade, credits));
    }

    public java.util.ArrayList<Module> getModules() {
        return gradesOverviewService.getModules();
    }

    public double getGPA() {
        return gradesOverviewService.calculateGPA();
    }
}
