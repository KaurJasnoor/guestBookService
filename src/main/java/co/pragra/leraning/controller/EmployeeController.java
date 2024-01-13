package co.pragra.leraning.controller;

import co.pragra.leraning.entities.Employee;
import co.pragra.leraning.repository.EmployeeRepo;
import co.pragra.leraning.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

   /* @Autowired
    EmployeeRepo employeeRepo;*/

    @Autowired
    EmployeeService employeeService;

    /*@GetMapping("/info/{id}")
    public String info(@RequestParam("name") String name, @PathVariable("id") Integer id){
        return "Hello " + name + " id : " +id+ ", I am Employee Book Service";
    }*/
    @GetMapping("/all")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }
    @GetMapping("/all/{id}")
    public Optional<Employee> getById(@PathVariable ("id") Integer id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/allByFirstName/{firstName}")
    public Optional<Employee> getByFirstName(@PathVariable ("firstName") String firstName){
        return employeeService.getEmployeeByFirstName(firstName);
    }
    @PostMapping("/add")
    public Employee addOrUpdateEmployee(@RequestBody Employee employee){
       // return employeeRepo.save(employee); // SAVE done the job for INSERT and UPDATE operations in database.
       // employee.setFirstName(employee.getFirstName()+employee.getFirstName());
        return employeeService.addOrUpdateEmployee(employee);
    }

    @DeleteMapping("/delete/ {id}")
    public Optional<Employee> deleteEmployee(@PathVariable ("id") Integer id){
        return employeeService.deleteEmployeeById(id);
    }
    @PostMapping("/update")
    public Optional<Employee> updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

}
