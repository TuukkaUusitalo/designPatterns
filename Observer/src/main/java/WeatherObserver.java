public class WeatherObserver implements Observer {
    private String name;

    public WeatherObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int newTemperature) {
        System.out.println("Observer " + name + " received temperature update: " + newTemperature + "°C");
    }

}
