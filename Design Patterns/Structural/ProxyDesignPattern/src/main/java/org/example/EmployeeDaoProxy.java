package org.example;

public class EmployeeDaoProxy implements EmployeeDao {
    private EmployeeDaoImpl employeeDaoImpl;

    public EmployeeDaoProxy() {
        this.employeeDaoImpl = new EmployeeDaoImpl();
    }

    public void create(String employeeName) {
        if (isAuthorized()) {
            System.out.println("Proxy: Authorizing request...");
            employeeDaoImpl.create(employeeName);
        } else {
            System.out.println("Proxy: Unauthorized access attempt.");
        }
    }

    private boolean isAuthorized() {
        // Mock authorization logic
        return true; // Change to false to simulate unauthorized access
    }
}
