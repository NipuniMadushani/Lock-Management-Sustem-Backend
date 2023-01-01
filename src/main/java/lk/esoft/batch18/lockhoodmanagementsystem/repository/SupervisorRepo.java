package lk.esoft.batch18.lockhoodmanagementsystem.repository;

import lk.esoft.batch18.lockhoodmanagementsystem.models.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface SupervisorRepo extends JpaRepository<Supervisor,Integer> {
}
