package ru.skystudent;

import java.util.Objects;

public class Employee {
    private static int id;
    private int employeeId;
    private String names;
    private int department;
    private float salary;

    public Employee(String names, int department, float salary) {
        employeeId += id;
        this.names = names;
        this.department = department;
        this.salary = salary;
        id++;
    }


    public String getNames() {
        return this.names;
    }

    public int getId() {
        return this.employeeId;
    }

    public int getDepartment() {
        return this.department;
    }

    public float getSalary() {
        return this.salary;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            System.out.println("Такого отдела не существует!");
            return;
        }
        this.department = department;
    }

    public void setSalary(float salary) {
        if (salary < 0) {
            System.out.println("Зарплата не может быть отрицательной!");
            return;
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id= " + employeeId +
                ", ФИО: " + names +
                ", отдел: " + department +
                ", зарплата: " + salary + " р." +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() && getDepartment() == employee.getDepartment() && Float.compare(employee.getSalary(), getSalary()) == 0 && getNames().equals(employee.getNames());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNames(), getDepartment(), getSalary());
    }

    public void setEmptyName() {
        this.names = " ";
    }

    public void setNames(String names) {
        this.names = names;
    }

}
