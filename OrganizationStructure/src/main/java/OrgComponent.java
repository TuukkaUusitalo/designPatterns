// OrgComponent.java
public interface OrgComponent {
    String getName();
    double getTotalSalary();
    String toXml(int indent);

    // Leaf nodes do not support add/remove:
    default void add(OrgComponent child) {
        throw new UnsupportedOperationException("Leaf cannot contain children");
    }
    default void remove(OrgComponent child) {
        throw new UnsupportedOperationException("Leaf cannot contain children");
    }
}