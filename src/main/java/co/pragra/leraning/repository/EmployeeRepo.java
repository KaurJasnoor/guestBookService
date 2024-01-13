package co.pragra.leraning.repository;

import co.pragra.leraning.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    Optional<Employee> findEmployeeByFirstName(String firstName);
}
