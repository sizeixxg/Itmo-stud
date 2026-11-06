package enums;

public enum WeatherCondition {
    FOG,
    CLEAR,
    STORM;

    public static WeatherCondition RandCondition(){
        WeatherCondition[]  options = values();
        WeatherCondition weather = options[(int) (Math.random() * options.length)];
        System.out.println("Погода: " + weather);
        return weather;
    }
}
