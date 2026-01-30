import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Department implements OrgComponent {

    private final String name;
    private final List<OrgComponent> children = new ArrayList<>(); // children can be Employees or Departments

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getTotalSalary() {
        double total = 0.0;
        for (OrgComponent child : children) {
            if (child instanceof Employee e) {
                total += e.getTotalSalary();
            } else if (child instanceof Department d) {
                total += d.getTotalSalary();
            }
        }
        return total;
    }

    @Override
    public void add(OrgComponent child) {
        children.add(child);
    }

    @Override
    public void remove(OrgComponent child) {
        children.remove(child);
    }

    @Override
    public String toXml(int indent) {
        String pad = " ".repeat(indent);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s<department name=\"%s\">%n", pad, name));
        for (OrgComponent child : children) {
            if (child instanceof Employee e) {
                sb.append(e.toXml(indent + 2)).append("\n");
            } else if (child instanceof Department d) {
                sb.append(d.toXml(indent + 2)).append("\n");
            }
        }
        sb.append(String.format("%s</department>", pad));
        return sb.toString();
    }

}
