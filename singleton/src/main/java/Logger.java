import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public final class Logger {
    private static volatile Logger instance;

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger(); // calls private construcotr
                }
            }
        }
        return instance;
    }

    // text fields
    private BufferedWriter writer;
    private String currentFileName;


    private static final String DEFAULT_FILE_NAME = "app.log";

    // constructor
    private Logger() {
        openWriter(DEFAULT_FILE_NAME);
        // (Valinnainen) sulje siististi prosessin päättyessä
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try { close(); } catch (Exception ignored) {}
        }));
    }


     // Closes the old logger file and opens a new with given name

    public synchronized void setFileName(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            System.err.println("Logger: File's name cannot be empty.");
            return;
        }
        if (fileName.equals(currentFileName)) {
            // fi same file, doing nothing
            return;
        }
        // here closes the old and opens a new
        closeQuietly();
        openWriter(fileName);
    }


    public synchronized void write(String message) {
        if (writer == null) {
            openWriter(DEFAULT_FILE_NAME);
        }
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println("Logger: Error while writing to log: " + e.getMessage());
        }
    }


    public synchronized void close() {
        closeQuietly();
    }

    // private helper methods
    private void openWriter(String fileName) {
        try {
            Path p = Path.of(fileName);
            this.writer = Files.newBufferedWriter(
                    p,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND   // adding after
            );
            this.currentFileName = fileName;
        } catch (IOException e) {
            this.writer = null;
            this.currentFileName = null;
            System.err.println("Logger: Faild to open the log file ('" + fileName + "'): " + e.getMessage());
        }
    }

    private void closeQuietly() {
        if (writer != null) {
            try {
                writer.flush();
            } catch (IOException ignored) {}
            try {
                writer.close();
            } catch (IOException ignored) {}
            writer = null;
        }
        currentFileName = null;
    }
}
