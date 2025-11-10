package de.crosscreate.gradecalc;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.crosscreate.gradecalc.grades.controller.GradesOverviewController;
import de.crosscreate.gradecalc.grades.service.GradesOverviewService;
import de.crosscreate.gradecalc.modules.model.Module;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@SpringBootApplication
public class GradecalcApplication implements CommandLineRunner {

	@Autowired
	GradesOverviewController gradesOverviewController;

	public static void main(String[] args) {
		SpringApplication.run(GradecalcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Willkommen bei GradeCalc!\n");
			System.out.println("Wie viele Module moechten Sie hinzufuegen?");
			int moduleCount = Integer.parseInt(scanner.nextLine());

			for (int i = 0; i < moduleCount; i++) {
				System.out.println("Geben Sie den Namen des " + (i + 1) + ". Moduls ein:");
				String name = scanner.nextLine();

				System.out.println("Geben Sie Ihre Note in " + name + " ein:");
				double grade = Double.parseDouble(scanner.nextLine());

				System.out.println("Geben Sie Ihre Credits für " + name + " ein:");
				double credits = Double.parseDouble(scanner.nextLine());

				gradesOverviewController.addModule(name, grade, credits);
			}
		}
		System.out.println("\nAlles Module:");

		for (Module module : gradesOverviewController.getModules()) {
			System.out.println(
					"- " + module.getName() + ": Note " + module.getGrade() + ", Credits " + module.getCredits());
		}

		System.out.println("\nDie berechnete GPA ist: " + gradesOverviewController.getGPA() + "\n\n");

		System.exit(0);
	}

	@PostConstruct
	public void initializeData() {
		// Das könnte man benutzen, um frühere Noteneinträge aus einer Datei oder
		// Datenbank immer mit zu laden.
		gradesOverviewController.addModule("Mathematik", 1.7, 5);
		gradesOverviewController.addModule("Informatik", 2.3, 10);
		gradesOverviewController.addModule("Datenbanken", 1.0, 5);
	}

	@PreDestroy
	public void printQuitMessage() {
		System.out.println("Vielen Dank fuer die Nutzung von GradeCalc. AufWiedersehen!");
	}

}
