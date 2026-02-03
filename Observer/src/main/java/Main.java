public class Main {
    public static void main(String[] args) {

        WeatherStation station = new WeatherStation();
        station.start();

        Observer o1 = new WeatherObserver("Observer 1");
        Observer o2 = new WeatherObserver("Observer 2");

        station.register(o1);
        station.register(o2);

        try {
            Thread.sleep(15000); // Let it run for 20 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        station.remove(o2);
        System.out.println("Observer 2 removed");

        //Then continuing the simulation
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
