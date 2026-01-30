import java.util.ArrayList;
import java.util.List;

public class Organization {
    private final String name;
    private final List<OrgComponent> topLevel = new ArrayList<>();

    public Organization(String name) {
        this.name = name;
    }

    public void add(OrgComponent component) {
        topLevel.add(component);
    }

    public void remove(OrgComponent component) {
        topLevel.remove(component);
    }

    public double getTotalSalary() {
        double sum = 0.0;
        for (OrgComponent c : topLevel) {
            sum += c.getTotalSalary();
        }
        return sum;
    }

    public void printTotalSalary() {
        System.out.printf("Total organization salary: %.2f%n", getTotalSalary());
    }

    public String toXml() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("<organization name=\"%s\">%n", name));
        sb.append(String.format("  <p> Total salary: \"%.2f\" </p>%n", getTotalSalary()));
        for (OrgComponent c : topLevel) {
            sb.append(c.toXml(2)).append(System.lineSeparator());
        }
        sb.append("</organization>");
        return sb.toString();
    }

    public void printXml() {
        System.out.println(toXml());
    }
}