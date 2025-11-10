package de.crosscreate.gradecalc.grades.service;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import de.crosscreate.gradecalc.modules.model.Module;

@Controller
public class GradesOverviewService {
    private ArrayList<Module> modules;

    public GradesOverviewService() {
        this.modules = new ArrayList<Module>();
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public Module addModule(Module module) {
        modules.add(module);
        return module;
    }

    public double calculateGPA() {
        double totalPoints = 0;
        double totalCredits = 0;

        for (Module module : modules) {
            totalPoints += module.getGrade() * module.getCredits();
            totalCredits += module.getCredits();
        }

        return totalCredits == 0 ? 0 : totalPoints / totalCredits;
    }
}
