package isi.utm.tn.tpdevav.repository;

import isi.utm.tn.tpdevav.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findPersonByEmail(String email);
	User findByUsername(String username);
    
}
