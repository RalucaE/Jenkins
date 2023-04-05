package com.example.spring;

import java.util.List;

public interface IEmployeesService {
    List<Employee> getEmployees();
    void createEmployee(Employee employee);
    void updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);
}
