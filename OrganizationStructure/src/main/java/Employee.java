import java.util.Scanner;

public class Employee implements OrgComponent {

    private final String name;
    private final double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getTotalSalary() {
        return salary;
    }


    @Override
    public String toXml(int indent) {
        String pad = " ".repeat(indent);
        return String.format("%s<employee name=\"%s\" salary=\"%.2f\"/>", pad, name, salary);
    }
}