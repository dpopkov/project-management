package learn.sprjrp.pma.dao;

import learn.sprjrp.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
