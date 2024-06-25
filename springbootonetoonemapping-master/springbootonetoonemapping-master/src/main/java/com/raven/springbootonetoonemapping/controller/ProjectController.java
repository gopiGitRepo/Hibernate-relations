package com.raven.springbootonetoonemapping.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raven.springbootonetoonemapping.entiry.Employee;
import com.raven.springbootonetoonemapping.entiry.Project;
import com.raven.springbootonetoonemapping.repository.EmployeeRepository;
import com.raven.springbootonetoonemapping.repository.ProjectRepository;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/createProject")
	public String createProject(@RequestBody List<Project> entities) {
		System.out.println("\nCreate a new Project.\n");
        List<Project> projects = new ArrayList<>();
		// new Project
		//Project project = new Project(entity.getProjectName(), entity.getTechnologyUsed());
		
		for(Project project : entities) {
			Project entity = Project.builder().projectName(project.getProjectName()).technologyUsed(project.getTechnologyUsed()).build();
			projects.add(entity);
		}

		// save Project
		 List<Project> allProjects = projectRepository.saveAll(projects);
		System.out.println("\nSaved Project :: " + allProjects + "\n");
		return "Project saved!!!";
	}

	@PostMapping("/createProjectForEmployees")
    public String createProjectForEmployee(@RequestBody Project entity) {
        System.out.println("\nCreate new Project and add existing Employees into this Project." + "\n");

        // get first Employee
        int emplId = 7;
        Employee employee1 = this.employeeRepository.getById(emplId);
        System.out.println("\nEmployee details :: " + employee1.toString() + "\n");

        // get first Employee
        emplId = 9;
        Employee employee2 = this.employeeRepository.getById(emplId);
        System.out.println("\nEmployee details :: " + employee2.toString() + "\n");

        // new Project
        Project project = new Project(entity.getProjectName(), 
        					entity.getTechnologyUsed());

        // create Employee set
        Set<Employee> employees = new HashSet<>();
        employees.add(employee1);
        employees.add(employee2);

        // assign Employee Set to Project
        project.setEmployees(employees);

        // save Project
        project = projectRepository.save(project);
        System.out.println("\nSaved Project :: " + project + "\n");

        return "Project saved!!!";
    }

	@PostMapping("/assignProjectToEmployees/{projId}/{empId}")
    public String assignProjectToEmployees(@PathVariable(name = "projId") Integer projId,
            @PathVariable(name = "empId") Integer empId) {
        System.out.println("\nFetch existing Project and add existing Employee into this Project." + "\n");

        // get Employee
        Employee employee = this.employeeRepository.getById(empId);
        System.out.println("\nEmployee details :: " + employee.toString() + "\n");

        // new Project
        Project project = this.projectRepository.getById(projId);
        System.out.println("\nProject details :: " + project.toString() + "\n");

        // create Employee set
        Set<Employee> employees = new HashSet<>();
        employees.add(employee);

        // assign Employee Set to Project
        project.setEmployees(employees);

        // save Project
        project = projectRepository.save(project);
        System.out.println("\nSaved Project :: " + project + "\n");

        return "Project saved!!!";
    }

	@GetMapping(value = "/getProject/{projId}")
	public String getProject(@PathVariable(name = "projId") Integer projId) {
		System.out.println("Fetch Project and its Employees." + "\n");

		// get Project details
		Project project = this.projectRepository.getById(projId);
		System.out.println("\nProject details :: " + project.toString() + "\n");
		System.out.println("\nEmployees details :: " + project.getEmployees() + "\n");

		System.out.println("Done!!!" + "\n");

		return "Project fetched successfully!!!";
	}

}