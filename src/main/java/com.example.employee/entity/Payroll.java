package com.example.employee.entity;


import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "payrolls")
public class Payroll implements Serializable {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@ManyToOne(optional = false)
@JoinColumn(name = "employee_id")
private Employee employee;


@Column(nullable = false)
private LocalDate payDate;


@Column(nullable = false)
private Double grossPay;


@Column(nullable = false)
private Double netPay;


// Constructors, getters, setters


public Payroll() {}


public Payroll(Employee employee, LocalDate payDate, Double grossPay, Double netPay) {
this.employee = employee;
this.payDate = payDate;
this.grossPay = grossPay;
this.netPay = netPay;
}


public Long getId() { return id; }
public void setId(Long id) { this.id = id; }


public Employee getEmployee() { return employee; }
public void setEmployee(Employee employee) { this.employee = employee; }


public LocalDate getPayDate() { return payDate; }
public void setPayDate(LocalDate payDate) { this.payDate = payDate; }


public Double getGrossPay() { return grossPay; }
public void setGrossPay(Double grossPay) { this.grossPay = grossPay; }


public Double getNetPay() { return netPay; }
public void setNetPay(Double netPay) { this.netPay = netPay; }
}
