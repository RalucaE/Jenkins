package com.example.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> getEmployeeByEmailAdress(String emailAdress);
}
