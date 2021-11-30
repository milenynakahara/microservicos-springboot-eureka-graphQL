package br.com.enterprise.pocuserservice.repositories;

import br.com.enterprise.pocuserservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
