package com.example.spring;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/employees")
public class EmployeesController {
    private final EmployeesService employeesService;

    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }


    @GetMapping()
    public List<Employee> getEmployees()
    {
        return employeesService.getEmployees();
    }
    @PostMapping
    public void createEmployee(@RequestBody Employee employee)
    {

        employeesService.createEmployee(employee);
    }
    @PutMapping(path = "{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employeesService.updateEmployee(id, employee);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEmployee(@PathVariable Long id)
    {
        employeesService.deleteEmployee(id);
    }
}
