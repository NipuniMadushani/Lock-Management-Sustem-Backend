package lk.esoft.batch18.lockhoodmanagementsystem.repository;

import lk.esoft.batch18.lockhoodmanagementsystem.models.Income;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface IncomeRepo extends JpaRepository<Income, Integer> {
}
