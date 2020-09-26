package weather;

/**
 * This class represents a single reading of a weather station in a Stevenson Screen.
 * A reading has the following attributes: the air temperature, the dew point temperature, the
 * wind speed, and the total rain received in the last 24 hours.
 *
 * */
public class WeatherReading {

  private final int temperature;
  private final int dewPoint;
  private final int windSpeed;
  private final int totalRain;

  /**
   * Constructs a {@code WeatherReading} object.
   *
   * @param temperature the air temperature in Celsius.
   * @param dewPoint temperature in Celsius at which water condenses and dew forms.
   * @param windSpeed  wind speed in miles per hour.
   * @param totalRain total rain received in the last 24 hours in millimeters.
   *
   * */
  public WeatherReading(int temperature, int dewPoint, int windSpeed, int totalRain)
          throws IllegalArgumentException {
    if (dewPoint > temperature) {
      throw new IllegalArgumentException("Dew point cannot be greater than air temperature.");
    }
    if (windSpeed < 0 ) {
      throw new IllegalArgumentException("Wind Speed cannot be negative.");
    }
    if (totalRain < 0 ) {
      throw new IllegalArgumentException("Total rain cannot be negative.");
    }
    this.temperature = temperature;
    this.dewPoint = dewPoint;
    this.windSpeed = windSpeed;
    this.totalRain = totalRain;
  }

  /**
   * Explains the {@code WeatherReading} object via overriding the toString method.
   * */
  @Override
  public String toString() {
    return "Reading: T = " + temperature + ", D = "
            + dewPoint + ", v = " + windSpeed + ", rain = " + totalRain;
//       return String.format("Reading: T = %d, D = %d, v = %d, rain = %d",
//            this.temperature,
//            this.dewPoint,
//            this.windSpeed,
//            this.totalRain);
  }

  /** Air temperature in Celsius for the reading.
   * @return Air Temperature
   * */
  public int getTemperature() {
    return temperature;
  }

  /**
   * Dew point is temperature in Celsius at which water condenses and dew forms.
   * @return Dew Point
   * */
  public int getDewPoint() {
    return dewPoint;
  }

  /**
   * Wind speed in miles per hour.
   * @return Wind Speed
   * */
  public int getWindSpeed() {
    return windSpeed;
  }

  /**
   * Total rain received in the last 24 hours in millimeters.
   * @return  total rain
   * */
  public int getTotalRain() {
    return totalRain;
  }

  /**
   * Calculates relative humidity using dew point and air temperature.
   * @return Relative humidity in percentage.
   * */
  public int getRelativeHumidity() {
    int relativeHumidity = 100 + 5 * (dewPoint - temperature);
    return relativeHumidity;
  }

  /**
   * Converts temperature in Celsius to Fahrenheit.
   * @return temperature in Fahrenheit.
   * */
  private int celsiusToFahrenheit() {
    return (int)(temperature * (9.0 / 5.0 ) + 32);
  }

  /**
   * Heat index is a measure of how hot it feels when relative humidity is
   * factored in with the actual temperature.
   * @return Heat Index
   * */
  public int getHeatIndex() {
    double relativeHumidity = 0.0;
    try {
      relativeHumidity = getRelativeHumidity();
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }

    final double c1 = -8.78469475556;
    final double c2 = 1.61139411;
    final double c3 = 2.33854883889;
    final double c4 = -0.14611605;
    final double c5 = -0.012308094;
    final double c6 = -0.0164248277778;
    final double c7 = 0.002211732;
    final double c8 = 0.00072546;
    final double c9 = -0.000003582;
    return (int)(c1 + c2 * temperature
            + c3 * relativeHumidity
            + c4 * temperature * relativeHumidity
            + c5 * Math.pow(temperature,2)
            + c6 * Math.pow(relativeHumidity,2)
            + c7 * Math.pow(temperature,2) * relativeHumidity
            + c8 * temperature * Math.pow(relativeHumidity,2)
            + c9 * Math.pow(temperature,2) * Math.pow(relativeHumidity,2));
  }

  /**
   * Wind chill is used when the real-feel temperature is lower than the actual temperature.
   * @return Wind chill
   * */
  public int getWindChill() {
    double temperatureF = celsiusToFahrenheit();
    return (int)(35.74 + 0.6215 * temperatureF
            - 35.75 * Math.pow(windSpeed, 0.16)
            + 0.4275 * temperatureF * Math.pow(windSpeed, 0.16));
  }

}
