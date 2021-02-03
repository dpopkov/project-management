package learn.sprjrp.pma.controllers;

import learn.sprjrp.pma.dao.ProjectRepository;
import learn.sprjrp.pma.entities.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SuppressWarnings("SameReturnValue")
@Slf4j
@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/new")
    public String displayForm(Model model) {
        log.debug("Initializing a form for new Project");
        model.addAttribute(new Project());
        return "new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project) {
        log.debug("Creating new Project name={}", project.getName());
        Project saved = projectRepository.save(project);
        log.debug("Saved Project ID={}", saved.getId());
        // Convention: Always use Redirect to prevent duplicate submissions
        return "redirect:/projects/new";
    }
}
