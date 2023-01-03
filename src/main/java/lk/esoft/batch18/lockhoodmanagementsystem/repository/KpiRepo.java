package lk.esoft.batch18.lockhoodmanagementsystem.repository;

import lk.esoft.batch18.lockhoodmanagementsystem.models.Kpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface KpiRepo extends JpaRepository<Kpi,Integer> {
}
