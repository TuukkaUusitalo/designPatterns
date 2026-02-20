public class EncryptedPrinter extends PrinterDecorator {

    public EncryptedPrinter(Printer wrappedPrinter) {
        super(wrappedPrinter);
    }

    @Override
    public void print(String message) {
        String encrypted = encrypt(message);
        super.print(encrypted);
    }

    // Adds +3 to each character
    private String encrypt(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append((char) (c + 3));
        }
        return sb.toString();
    }
}