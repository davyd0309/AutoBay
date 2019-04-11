package pl.witkowski.AutoBay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.witkowski.AutoBay.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    User findByUsername(String username);

    User findByEmail(String email);
}
