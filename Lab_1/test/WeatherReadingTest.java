import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import weather.WeatherReading;

/**
 * Test cases for Weather Reading class.
 * */
public class WeatherReadingTest {

  private WeatherReading day1;

  @Test
  public void setupTest() {
    day1 = new WeatherReading(23, 12, 3, 12);
    assertEquals("Reading: T = 23, D = 12, v = 3, rain = 12", day1.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegWindSpeed() {
    day1 = new WeatherReading(23, 12, -1,12);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegTotalRain() {
    day1 = new WeatherReading(23, 12, 3, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDewPointCondition() {
    day1 = new WeatherReading(23, 25, 3, 30);
  }

  @Before
  public void setDay1() {
    day1 = new WeatherReading(23, 12, 3, 12);
  }

  @Test
  public void testGetTemperature() {
    assertEquals(23, day1.getTemperature(),0);
  }

  @Test
  public void testGetDewPoint() {
    assertEquals(12, day1.getDewPoint(),0);
  }

  @Test
  public void testGetWindSpeed() {
    assertEquals(3, day1.getWindSpeed(),0);
  }

  @Test
  public void testGetTotalRain() {
    assertEquals(12, day1.getTotalRain(),0);
  }

  @Test
  public void testGetRelativeHumidity() {
    assertEquals(45, day1.getRelativeHumidity(),0);
  }

  @Test
  public void testGetHeatIndex() {
    assertEquals(25, day1.getHeatIndex(),0);
  }

  @Test
  public void testGetWindChill() {
    assertEquals(75, day1.getWindChill(),0);
  }

}
