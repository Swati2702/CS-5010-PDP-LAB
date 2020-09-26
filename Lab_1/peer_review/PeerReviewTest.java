import java.util.Random;

import org.junit.Test;

import weather.WeatherReading;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * A JUnit test for WeatherReading class.
 */
public class WeatherReadingTest {
  // Weather reading object to be used for testing
  private WeatherReading reading;

  /**
   * Test a valid weather reading object creation and reading its attributes.
   */
  @Test
  public void testAValidReadingObject() {
    // Creates a reading object with fixed parameters
    reading = new WeatherReading(20, 15, 7, 4);

    // Verifies result with expected output
    assertEquals(20, reading.getTemperature());
    assertEquals(15, reading.getDewPoint());
    assertEquals(7, reading.getWindSpeed());
    assertEquals(4, reading.getTotalRain());
    assertEquals(75, reading.getRelativeHumidity());
    assertEquals(22, reading.getHeatIndex());
    assertEquals(68, reading.getWindChill());
  }

  /**
   * Test multiple valid weather reading objects creation and reading its attributes. It randomly
   * assigns values to its object.
   */
  @Test
  public void testMultipleValidReadingObject() {
    Random r = new Random();

    // Runs loop for 10000 times to test randomly created reading object
    for (int i = 0; i < 10000; i++) {
      // Randomly assigns values to the parameters using Random class
      int temperature = r.nextInt();
      int dewPoint = r.nextInt();
      int windSpeed = r.nextInt();
      int totalRain = r.nextInt();

      // Skip over any invalid arguments so that only the valid object can be tested
      if (dewPoint > temperature || windSpeed < 0 || totalRain < 0) {
        continue;
      }

      // Calculates relative humidity
      reading = new WeatherReading(temperature, dewPoint, windSpeed, totalRain);
      int relativeHumidity = 100 - (5 * (temperature - dewPoint));

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

      // Calculates heat index
      int heatIndex = (int) (c1 + c2 * temperature + c3 * relativeHumidity
              + c4 * temperature * relativeHumidity
              + c5 * Math.pow(temperature, 2)
              + c6 * Math.pow(relativeHumidity, 2)
              + c7 * Math.pow(temperature, 2) * relativeHumidity
              + c8 * temperature * Math.pow(relativeHumidity, 2)
              + c9 * Math.pow(temperature, 2) * Math.pow(relativeHumidity, 2));

      // Calculates temperature in Fahrenheit and calculates wind chill
      float tempInF = 32 + (float) (temperature * 9 / 5);
      int windChill = (int) (35.74 + 0.6215 * tempInF - 35.75 * Math.pow(windSpeed, 0.16) +
              0.4275 * tempInF * Math.pow(windSpeed, 0.16));

      // Tests desired output with reading object fields
      assertEquals(temperature, reading.getTemperature());
      assertEquals(dewPoint, reading.getDewPoint());
      assertEquals(windSpeed, reading.getWindSpeed());
      assertEquals(totalRain, reading.getTotalRain());
      assertEquals(relativeHumidity, reading.getRelativeHumidity());
      assertEquals(heatIndex, reading.getHeatIndex());
      assertEquals(windChill, reading.getWindChill());
    }
  }

  /**
   * Test validation for incorrect dew point attribute of weather reading object.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidDewPointReadingObject() {
    // Invalid object with dew point greater than temperature
    reading = new WeatherReading(22, 23, 8, 2);
  }

  /**
   * Test validation for incorrect wind speed attribute of weather reading object.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidWindSpeedReadingObject() {
    // Invalid object with negative wind speed
    reading = new WeatherReading(25, 20, -1, 5);
  }

  /**
   * Test validation for incorrect  attribute of weather reading object.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTotalRainReadingObject() {
    // Invalid object with negative total rain
    reading = new WeatherReading(15, 9, 2, -10);
  }

  /**
   * Test validation for overridden toString method of weather reading object with correct value.
   */
  @Test
  public void testValidStringRepresentationReadingObject() {
    // Create valid reading object
    reading = new WeatherReading(12, 9, 5, 2);

    // Test against valid value
    String expectedValue = "Reading: T = 12, D = 9, v = 5, rain = 2";
    assertEquals(expectedValue, reading.toString());
  }

  /**
   * Test validation for overridden toString method of weather reading object with incorrect value.
   */
  @Test
  public void testInvalidStringRepresentationReadingObject() {
    // Create valid reading object
    reading = new WeatherReading(12, 9, 5, 2);

    // Test against invalid value
    String unExpectedValue = "Reading: rain = 2, T = 12, D = 9, v = 5";
    assertNotEquals(unExpectedValue, reading.toString());
  }
}