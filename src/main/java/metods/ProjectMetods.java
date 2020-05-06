package metods;

import model.Project;
import repositories.ProjectService;

import java.util.Scanner;

public class ProjectMetods {

    public void addProjectFromKeyboard(int i) {
        if (i ==1){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter name, identifier and description.");
            String nume;
            nume = scanner.nextLine();
            String identificator;
            identificator = scanner.nextLine();
            String descriere;
            descriere = scanner.nextLine();
            Project project = new Project(nume,identificator,descriere);
            ProjectService projectService = new ProjectService();
            projectService.addProject(project);

        }

    }

}
