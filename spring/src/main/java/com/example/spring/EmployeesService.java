package com.example.spring;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService implements IEmployeesService{
    private final EmployeesRepository employeesRepository;

    public EmployeesService(EmployeesRepository employeesRepository)
    {
        this.employeesRepository = employeesRepository;
    }
    @Override
    public List<Employee> getEmployees()
    {
        return employeesRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }
    @Override
    public void createEmployee(Employee employee)
    {
        validateEmail(employee.getEmailAdress());
        employeesRepository.save(employee);
    }
    @Override
    public void updateEmployee(Long id, Employee employee)
    {
        Employee employeeToUpdate = employeesRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("Employee with id %s doesn't exist",id)));
        validateEmail(employee.getEmailAdress());


        employeeToUpdate.setFirstName(employee.getFirstName());
        employeeToUpdate.setLastName(employee.getLastName());
        employeeToUpdate.setAge(employee.getAge());
        employeeToUpdate.setEmailAdress(employee.getEmailAdress());
        employeeToUpdate.setAdress(employee.getAdress());
        employeeToUpdate.setRole(employee.getRole());

        employeesRepository.save(employeeToUpdate);
    }

    @Override
    public void deleteEmployee(Long id)
    {
        boolean employeeExists = employeesRepository.existsById(id);
        if(!employeeExists)
        {
            throw new IllegalStateException(String.format("Employee with id %s does not exist",id));
        }
        employeesRepository.deleteById(id);
    }

    private void validateEmail(String email)
    {
        Optional<Employee> employeeOptional = employeesRepository.getEmployeeByEmailAdress(email);
        if(employeeOptional.isPresent())
        {
            throw new IllegalStateException(String.format("Email address %s already exists",email));
        }
    }
}
