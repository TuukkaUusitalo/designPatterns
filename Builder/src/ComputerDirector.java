public class ComputerDirector {
    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer constructComputer() {
        String processor = builder.buildProcessor();
        float ram = builder.buildRAM();
        String hardDrive = builder.buildHardDrive();
        String graphicsCard = builder.buildGraphicsCard();
        String operatingSystem = builder.buildOperatingSystem();

        return new Computer(processor, ram, hardDrive, graphicsCard, operatingSystem);
    }
}
