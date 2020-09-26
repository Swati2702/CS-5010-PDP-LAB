import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import transmission.AutomaticTransmission;
import transmission.Transmission;

/**
 * Tests for {@link AutomaticTransmission}s.
 * */
public class AutomaticTransmissionTest {

  private Transmission t1;

  @Test
  public void testInitialization() {
    t1 = new AutomaticTransmission(2, 4, 6, 8, 10);
    assertEquals("Transmission (speed = 0, gear = 0)", t1.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsNegativeSpeed1() {
    t1 = new AutomaticTransmission(-2, 4, 6, 8, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsNegativeSpeed2() {
    t1 = new AutomaticTransmission(2, -4, 6, 8, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsNegativeSpeed3() {
    t1 = new AutomaticTransmission(2, 4, -6, 8, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsNegativeSpeed4() {
    t1 = new AutomaticTransmission(2, 4, 6, -8, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsNegativeSpeed5() {
    t1 = new AutomaticTransmission(2, 4, 6, 8, -10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsIncorrectGearSpeed1() {
    t1 = new AutomaticTransmission(5, 4, 6, 8, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsIncorrectGearSpeed2() {
    t1 = new AutomaticTransmission(2, 7, 6, 8, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsIncorrectGearSpeed3() {
    t1 = new AutomaticTransmission(2, 3, 12, 8, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsIncorrectGearSpeed4() {
    t1 = new AutomaticTransmission(2, 7, 6, 18, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsIncorrectGearSpeed5() {
    t1 = new AutomaticTransmission(2, 7, 6, 8, 1);
  }

  @Before
  public void setTransmissionObject() {
    t1 = new AutomaticTransmission(5, 7, 9, 11, 20);
  }

  @Test
  public void testIncreaseSpeed1() {
    Transmission t2 = t1.increaseSpeed();
    assertEquals("Transmission (speed = 2, gear = 1)", t2.toString());
  }

  @Test
  public void testIncreaseSpeed2() {
    Transmission t2 = t1.increaseSpeed();
    Transmission t3 = t2.increaseSpeed();
    Transmission t4 = t3.increaseSpeed();
    assertEquals("Transmission (speed = 6, gear = 2)", t4.toString());
  }

  @Test
  public void testDecreaseSpeed1() {
    Transmission t2 = t1.increaseSpeed();
    Transmission t3 = t2.increaseSpeed();
    Transmission t4 = t3.decreaseSpeed();
    assertEquals("Transmission (speed = 2, gear = 1)", t4.toString());
  }

  @Test
  public void testDecreaseSpeed2() {
    Transmission t2 = t1.increaseSpeed();
    Transmission t3 = t2.increaseSpeed();
    Transmission t4 = t3.increaseSpeed();
    Transmission t5 = t4.decreaseSpeed();
    assertEquals("Transmission (speed = 4, gear = 1)", t5.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testDecreaseSpeedDisallowsNegativeSpeed1() {
    t1.decreaseSpeed();
  }

  @Test(expected = IllegalStateException.class)
  public void testDecreaseSpeedDisallowsNegativeSpeed2() {
    Transmission t2 = t1.increaseSpeed();
    Transmission t3 = t2.decreaseSpeed();
    t3.decreaseSpeed();
  }

  @Test
  public void testGetGear() {
    Transmission t = new AutomaticTransmission(3, 5, 7, 9, 10);
    Transmission t1 = t.increaseSpeed();
    assertEquals(1, t1.getGear());
  }

  @Test
  public void testGetSpeed() {
    Transmission t = new AutomaticTransmission(3, 5, 7, 9, 10);
    Transmission t_new = t.increaseSpeed();
    assertEquals(2, t_new.getSpeed());
  }

}
