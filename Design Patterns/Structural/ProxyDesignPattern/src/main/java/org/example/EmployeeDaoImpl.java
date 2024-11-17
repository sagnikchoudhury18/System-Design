package org.example;

public class EmployeeDaoImpl implements EmployeeDao {

    public void create(String employeeName) {
        System.out.println("Employee " + employeeName + " has been created.");
    }
}
