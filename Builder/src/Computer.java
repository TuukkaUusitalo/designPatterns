public class Computer {
    private String processor;
    private float ram;
    private String hard_drive;
    private String graphics_card;
    private String operating_system;

    public Computer(String processor, float ram, String hard_drive, String graphics_card, String operating_system) {
        this.processor = processor;
        this.ram = ram;
        this.hard_drive = hard_drive;
        this.graphics_card = graphics_card;
        this.operating_system = operating_system;
    }

    @Override
    public String toString() {
        return "Processor: " + processor +
                ", RAM: " + ram + "GB" +
                ", Hard Drive: " + hard_drive +
                ", Graphics Card: " + graphics_card +
                ", OS: " + operating_system;
    }

}
