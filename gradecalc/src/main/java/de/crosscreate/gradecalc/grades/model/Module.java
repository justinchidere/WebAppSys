package de.crosscreate.gradecalc.grades.model;

public class Module {
    private String name;
    private double grade;
    private double credits;

    public Module(String name, double grade, double credits) {
        this.name = name;
        this.grade = grade;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public double getCredits() {
        return credits;
    }
    
}
