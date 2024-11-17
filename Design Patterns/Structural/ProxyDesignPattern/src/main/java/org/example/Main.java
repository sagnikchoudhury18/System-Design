package org.example;

public class Main {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoProxy(); // Using proxy
        employeeDao.create("John Doe"); // Proxy controls access to EmployeeDaoImpl
    }
}
