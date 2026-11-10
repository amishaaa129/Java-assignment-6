import java.io.*;

class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    int empId;
    String name;
    String department;
    double salary;

    Employee(int empId, String name, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("--------------------");
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {

        // Create employee objects
        Employee e1 = new Employee(101, "Rahul", "IT", 50000);
        Employee e2 = new Employee(102, "Priya", "HR", 45000);
        Employee e3 = new Employee(103, "Aman", "Finance", 60000);

        // Serialization
        try (
            ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("employees.dat")
            )
        ) {
            oos.writeObject(e1);
            oos.writeObject(e2);
            oos.writeObject(e3);

            System.out.println("Employees serialized successfully.");

        } catch (IOException e) {
            System.out.println("Serialization Error: " + e.getMessage());
        }

        // Deserialization
        try (
            ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("employees.dat")
            )
        ) {
            System.out.println("\nRetrieved Employee Records:");

            Employee emp;

            for (int i = 0; i < 3; i++) {
                emp = (Employee) ois.readObject();
                emp.display();
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization Error: " + e.getMessage());
        }
    }
}
