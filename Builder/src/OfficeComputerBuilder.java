public class OfficeComputerBuilder implements ComputerBuilder {
        public String buildProcessor() {
            return "Intel Core i5-11400";
        }

        @Override
        public float buildRAM() {
            return 16;
        }

        @Override
        public String buildHardDrive() {
            return "512GB SSD";
        }

        @Override
        public String buildGraphicsCard() {
            return "Integrated Graphics";
        }

        @Override
        public String buildOperatingSystem() {
            return "Windows 10 Home";
        }
}
