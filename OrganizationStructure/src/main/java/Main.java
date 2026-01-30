public class Main {
    public static void main(String[] args) {
        Organization org = new Organization("Gyyti");

        Department sales = new Department("Sales");
        sales.add(new Employee("Seller1", 1500));
        sales.add(new Employee("Seller2", 1500));

        Department dev = new Department("Development");
        dev.add(new Employee("Dev1", 1500));
        dev.add(new Employee("Dev2", 1500));

        org.add(sales);
        org.add(dev);

        org.printXml();
        //org.printTotalSalary();
    }
}