package lk.esoft.batch18.lockhoodmanagementsystem.repository;

import lk.esoft.batch18.lockhoodmanagementsystem.models.KanBanCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.JsonPath;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface KanBanRepo extends JpaRepository<KanBanCard,Integer> {
}
