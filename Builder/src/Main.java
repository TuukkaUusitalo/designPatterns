public class Main {
    public static void main(String[] args) {
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector(gamingBuilder);
        Computer gamingComputer = director.constructComputer();

        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director = new ComputerDirector(officeBuilder);
        Computer officeComputer = director.constructComputer();

        System.out.println("Gaming Computer: " + gamingComputer);
        System.out.println("Office Computer: " + officeComputer);
    }
}
