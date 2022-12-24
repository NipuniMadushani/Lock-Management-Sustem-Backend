package lk.esoft.batch18.lockhoodmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.esoft.batch18.lockhoodmanagementsystem.models.ERole;
import lk.esoft.batch18.lockhoodmanagementsystem.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
