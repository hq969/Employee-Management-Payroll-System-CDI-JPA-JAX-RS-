package com.example.employee.service;


import com.example.employee.entity.Employee;
import com.example.employee.repo.GenericRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;


@ApplicationScoped
public class EmployeeService {


@Inject
GenericRepository<Employee> repo;


public Employee find(Long id) { return repo.find(Employee.class, id); }


public List<Employee> list() { return repo.list(Employee.class); }


@Transactional
public Employee create(Employee e) {
// Basic validation
if (e.getBasicSalary() == null) e.setBasicSalary(0.0);
return repo.save(e);
}


@Transactional
public Employee update(Employee e) { return repo.update(e); }


@Transactional
public void delete(Long id) { repo.delete(Employee.class, id); }
}
