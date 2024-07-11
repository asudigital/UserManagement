package springBoot.userManagement.springbootrestfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springBoot.userManagement.springbootrestfulwebservices.entity.User;


//SpringDataJpa takes 2 arguments i.e. Entity name and data type of primary key
public interface UserRepository extends JpaRepository<User, Long> {
}
