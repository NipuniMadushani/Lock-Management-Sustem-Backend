package lk.esoft.batch18.lockhoodmanagementsystem.repository;

import lk.esoft.batch18.lockhoodmanagementsystem.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DepartmentRepo extends JpaRepository<Department,Integer> {
}