package com.example.employee.service;

import com.example.employee.entity.Payroll;
import com.example.employee.entity.Employee;
import com.example.employee.repo.GenericRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class PayrollService {

    @Inject
    GenericRepository<Payroll> repo;

    @Inject
    EmployeeService employeeService;

    public Payroll find(Long id) { return repo.find(Payroll.class, id); }

    public List<Payroll> list() { return repo.list(Payroll.class); }

    @Transactional
    public Payroll generatePayroll(Long employeeId, LocalDate payDate) {
        Employee emp = employeeService.find(employeeId);
        if (emp == null) throw new IllegalArgumentException("Employee not found");

        double gross = emp.getBasicSalary();
        double deductions = gross * 0.20;
        double net = gross - deductions;

        Payroll p = new Payroll(emp, payDate, gross, net);
        return repo.save(p);
    }
}
