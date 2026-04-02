public class GamingComputerBuilder implements ComputerBuilder {
    public String buildProcessor() {
        return "Intel Core i9-11900K";
    }

    @Override
    public float buildRAM() {
        return 24;
    }

    @Override
    public String buildHardDrive() {
        return "1TB SSD";
    }

    @Override
    public String buildGraphicsCard() {
        return "NVIDIA GeForce RTX 3080";
    }

    @Override
    public String buildOperatingSystem() {
        return "Windows 10 Pro";
    }
}
