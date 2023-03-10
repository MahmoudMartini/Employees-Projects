package control;

import java.sql.SQLException;
import java.util.ArrayList;
import model.*;

public class JDBCDemo {

    static void testEmployee() {
        Employee employee = new Employee(53, "Borriss", "Accounts");
//        employee = new Employee(53, null, null);
        int r = 0;
        try {
            r = employee.dbInsert();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.getMessage());
        }
        if (r > 0) {
            System.out.println(r + " Updated successfully!");
        }

        ArrayList<Employee> arr = null;
        try {
            arr = Employee.getResultSet();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.getMessage());
        }
        for (Employee e : arr) {
            System.out.println(e.toString());
        }
    }
    static void testProject() {
        Project project = new Project("Z", "25-OCT-22");
        int r = 0;
        try {
            r = project.dbDelete();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.getMessage());
        }
        if (r > 0) {
            System.out.println("Updated successfully");
        }

        ArrayList<Project> arr = null;
        try {
            arr = Project.getResultSet();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.getMessage());
        }
        for (Project e : arr) {
            System.out.println(e.toString());
        }
    }
    static void testDepartment() {
        Department department = new Department("HR", "Fadi");
        int r = 0;
        try {
            r = department.dbDelete();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.getMessage());
        }
        if (r > 0) {
            System.out.println(r + " Updated successfully!");
        }

        ArrayList<Department> arr = null;
        try {
            arr = Department.getResultSet();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.getMessage());
        }
        for (Department e : arr) {
            System.out.println(e.toString());
        }
    }
    static void testEmpProj() {
        EmpProj empProj = new EmpProj(7, "A", "Aleppo", 22);
        empProj = new EmpProj(7, "A", null, 0);
        int r = 0;
        try {
            r = empProj.dbUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.getMessage());
        }
        if (r > 0) {
            System.out.println(r + " Updated successfully!");
        }

        ArrayList<EmpProj> arr = null;
        try {
            arr = EmpProj.getResultSet();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.getMessage());
        }
        for (EmpProj e : arr) {
            System.out.println(e.toString());
        }
    }
    
    static void testEmployeeEmpProj() {
        Employee employee = new Employee(5, null, null);
        ArrayList<EmpProj> arr = null;
        try {
            arr = EmpProj.getResultSet(employee);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.getMessage());
        }
        for (EmpProj e : arr) {
            System.out.println(e.toString());
        }
    }
    static void testProjectEmpProj() {
        ArrayList<EmpProj> arr = null;
        try {
            arr = EmpProj.getResultSet(new Project("D", null));
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        for (EmpProj e : arr) {
            System.out.println(e.toString());
        }
    }
    static void testDepartmentEmp() {
        ArrayList<Employee> arr = null;
        try {
            arr = Employee.getResultSet(new Department("Accounts", null));
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        for (Employee e : arr) {
            System.out.println(e.toString());
        }
    }
    
    static void testModelId() {
        Project proj = null;
        Employee emp = null;
        EmpProj ep = null;
        Department d = null;
        try {
            proj = Project.getFromId("D");
            emp = Employee.getFromNo(5);
            ep = EmpProj.getFromId(5, "A");
            d = Department.getFromDept("Accounts");
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(proj.toString());
        System.out.println(emp.toString());
        System.out.println(ep.toString());
        System.out.println(d.toString());
    }
    
    public static void main(String[] args) {
        testModelId();
//        System.out.println(new EmpProj(1, null, null, 1).isValid());
//        System.out.println(new EmpProj(1, "A", null, 1).isValid());
//        System.out.println(new EmpProj(1, null, "City", 1).isValid());
//        System.out.println(new EmpProj(1, "A", "City", 1).isValid());
//        System.out.println(new EmpProj(1, "A", "", 1).isValid());
//        System.out.println(new EmpProj(1, "", "City", 1).isValid());
//        System.out.println(new EmpProj(1, "", "", 1).isValid());
//        System.out.println(new EmpProj(0, "A", "City", 1).isValid());
//        System.out.println(new EmpProj(1, "A", "City", 0).isValid());
//        System.out.println(new EmpProj(0, "", "", 0).isValid());
    }
}
