import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation extends Thread {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;
    private final int minTemp = -20;
    private final int maxtemp = 30;

    private Random rand = new Random();


    public WeatherStation() {
        this.temperature = rand.nextInt(20); // Initial random temperature
    }

    public void register(Observer o) {
        observers.add(o);
    }

    public void remove(Observer o) {
        observers.remove(o);
    }

    private void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }


    @Override
    public void run() {
        while (true) {
            try {
                int sleepTime = 1000 + rand.nextInt(3000); // Sleep between 1 to 4 seconds
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Temperature change: +1 or -1
            int change = rand.nextBoolean() ? 1 : -1;
            int newTemp = temperature + change;

            if (newTemp >= minTemp && newTemp <= maxtemp) {
                temperature = newTemp;
                System.out.println("WeatherStation: updated temperature to " + temperature);
                notifyObservers(); // Notify all observers of the change
            }
        }
    }
}
