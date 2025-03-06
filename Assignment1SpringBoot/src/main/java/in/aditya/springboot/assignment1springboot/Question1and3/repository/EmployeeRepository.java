package in.aditya.springboot.assignment1springboot.Question1and3.repository;


import in.aditya.springboot.assignment1springboot.Question1and3.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}