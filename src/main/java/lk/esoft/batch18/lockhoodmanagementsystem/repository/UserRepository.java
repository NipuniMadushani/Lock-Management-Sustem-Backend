package lk.esoft.batch18.lockhoodmanagementsystem.repository;

import java.util.List;
import java.util.Optional;

import lk.esoft.batch18.lockhoodmanagementsystem.payload.request.SignupRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.esoft.batch18.lockhoodmanagementsystem.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);


  Page<User> findAll(Pageable pageable);

  long countAllBy();

  User getByIdAndActiveState(Long userId,boolean b);
}
