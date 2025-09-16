package com.example.employee.entity;


import jakarta.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "employees")
public class Employee implements Serializable {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(nullable = false)
private String firstName;


@Column(nullable = false)
private String lastName;


@Column(nullable = false, unique = true)
private String email;


@Column(nullable = false)
private Double basicSalary;


// Constructors, getters, setters


public Employee() {}


public Employee(String firstName, String lastName, String email, Double basicSalary) {
this.firstName = firstName;
this.lastName = lastName;
this.email = email;
this.basicSalary = basicSalary;
}


public Long getId() { return id; }
public void setId(Long id) { this.id = id; }


public String getFirstName() { return firstName; }
public void setFirstName(String firstName) { this.firstName = firstName; }


public String getLastName() { return lastName; }
public void setLastName(String lastName) { this.lastName = lastName; }


public String getEmail() { return email; }
public void setEmail(String email) { this.email = email; }


public Double getBasicSalary() { return basicSalary; }
public void setBasicSalary(Double basicSalary) { this.basicSalary = basicSalary; }
}
