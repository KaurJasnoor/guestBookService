package co.pragra.leraning.services;

import co.pragra.leraning.entities.Employee;
import co.pragra.leraning.repository.EmployeeRepo;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Data
//@Component
@Service
//@Component and @Service does the exact same thing.
public class EmployeeService {

    public final EmployeeRepo employeeRepo;
    //final represents the constrictor base injecting.

    //Autowired is setter base injecting.

  public Employee addOrUpdateEmployee(Employee employee){
      return employeeRepo.save(employee);
  }

  public List<Employee> getAll(){
      return employeeRepo.findAll();
  }

  public Optional<Employee> getEmployeeById(Integer id){
      return employeeRepo.findById(id);
  }
  public Optional<Employee> getEmployeeByFirstName(String firstName){
      return employeeRepo.findEmployeeByFirstName(firstName);
  }
  public Optional<Employee> deleteEmployeeById(Integer id){
        //Optional<Employee> optionalEmployee = Optional.empty();
        Optional<Employee> employeeById = getEmployeeById(id);
        if (employeeById.isPresent()){
            employeeRepo.deleteById(id);
            return employeeById;
        }
        return Optional.empty();
  }

  public Optional<Employee> updateEmployee(Employee employee){
    Optional<Employee> employeeById = getEmployeeById(employee.getId());
    if (employeeById.isPresent()){
        return Optional.of(addOrUpdateEmployee(employee));
    }
    return Optional.empty();
  }

}

