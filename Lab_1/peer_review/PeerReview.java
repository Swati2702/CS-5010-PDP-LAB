package weather;

/**
 * This class represents a Weather Reading indexes. Weather reading has temperature, dew point, wind
 * speed, total rain, relative humidity, heat index and wind chill attributes.
 */
public class WeatherReading2 {
  // Fields for the weather reading class
  private final int temperature;
  private final int dewPoint;
  private final int windSpeed;
  private final int totalRain;
  private final int relativeHumidity;
  private final int heatIndex;
  private final int windChill;

  /**
   * Construct a WeatherReading object that has the provided temperature, dewPoint, windSpeed and
   * totalRain.
   *
   * @param temperature air temperature in Celsius to be given to this weather reading
   * @param dewPoint    dew point temperature in Celsius to be given to this weather reading
   * @param windSpeed   wind speed in mph to be given to this weather reading
   * @param totalRain   rain received in last 24 hrs in mm to be given to this weather reading
   * @throws IllegalArgumentException exception, when dew point is greater than air temperature in
   *                                  Celsius or wind speed has negative value or total rain
   *                                  received has negative value
   */
  public WeatherReading2(int temperature, int dewPoint, int windSpeed, int totalRain) {
    // Validates input parameters
    if (dewPoint > temperature || windSpeed < 0 || totalRain < 0) {
      // Throws IllegalArgumentException when invalid value found
      throw new IllegalArgumentException("Invalid Input Parameters.");
    }

    // Sets this weather reading object fields
    this.temperature = temperature;
    this.dewPoint = dewPoint;
    this.windSpeed = windSpeed;
    this.totalRain = totalRain;
    this.relativeHumidity = populateRelativeHumidity();
    this.heatIndex = populateHeatIndex();
    this.windChill = populateWindChill();
  }

  /**
   * Calculate and returns the relative humidity value based on temperature and dew point of this
   * weather reading.
   *
   * @return the relative humidity of this weather reading
   */
  private int populateRelativeHumidity() {
    // Calculates and returns relative humidity value
    return 100 - (5 * (this.temperature - this.dewPoint));
  }

  /**
   * Calculate and returns the heat index based on temperature and relative humidity of this weather
   * reading.
   *
   * @return the heat index of this weather reading
   */
  private int populateHeatIndex() {
    // Defines heat index constants
    double c1 = -8.78469475556;
    double c2 = 1.61139411;
    double c3 = 2.33854883889;
    double c4 = -0.14611605;
    double c5 = -0.012308094;
    double c6 = -0.0164248277778;
    double c7 = 0.002211732;
    double c8 = 0.00072546;
    double c9 = -0.000003582;

    // Calculates and returns heat index value
    return (int) (c1 + c2 * this.temperature + c3 * this.relativeHumidity
            + c4 * this.temperature * this.relativeHumidity
            + c5 * Math.pow(this.temperature, 2)
            + c6 * Math.pow(this.relativeHumidity, 2)
            + c7 * Math.pow(this.temperature, 2) * this.relativeHumidity
            + c8 * this.temperature * Math.pow(this.relativeHumidity, 2)
            + c9 * Math.pow(this.temperature, 2) * Math.pow(this.relativeHumidity, 2));
  }

  /**
   * Calculate and returns the wind chill based on temperature in F and wind speed of this weather
   * reading.
   *
   * @return the heat index of this weather reading
   */
  private int populateWindChill() {
    // Calculate air temperature in Fahrenheit
    float tempInF = 32 + (float) (this.temperature * 9 / 5);

    // Calculates and returns wind chill value
    return (int) (35.74 + 0.6215 * tempInF - 35.75 * Math.pow(this.windSpeed, 0.16)
            + 0.4275 * tempInF * Math.pow(this.windSpeed, 0.16));
  }

  /**
   * Return the temperature of this weather reading.
   *
   * @return the temperature of this weather reading
   */
  public int getTemperature() {
    return this.temperature;
  }

  /**
   * Return the dew point of this weather reading.
   *
   * @return the dew point of this weather reading
   */
  public int getDewPoint() {
    return this.dewPoint;
  }

  /**
   * Return the wind speed of this weather reading.
   *
   * @return the wind speed of this weather reading
   */
  public int getWindSpeed() {
    return this.windSpeed;
  }

  /**
   * Return the total rain of this weather reading.
   *
   * @return the total rain of this weather reading
   */
  public int getTotalRain() {
    return this.totalRain;
  }

  /**
   * Return the relative humidity of this weather reading.
   *
   * @return the relative humidity of this weather reading
   */
  public int getRelativeHumidity() {
    return this.relativeHumidity;
  }

  /**
   * Return the heat index of this weather reading.
   *
   * @return the heat index of this weather reading
   */
  public int getHeatIndex() {
    return this.heatIndex;
  }

  /**
   * Return the wind chill of this weather reading.
   *
   * @return the wind chill of this weather reading
   */
  public int getWindChill() {
    return this.windChill;
  }

  /**
   * Return the string representation of this weather reading.
   *
   * @return the string representation of this weather reading
   */
  @Override
  public String toString() {
    // Formats reading values in desired format and returns the value
    return String.format("Reading: T = %d, D = %d, v = %d, rain = %d",
            this.temperature,
            this.dewPoint,
            this.windSpeed,
            this.totalRain);
  }
}