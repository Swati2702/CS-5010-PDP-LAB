package transmission;

/**
 * Transmission represents a single car transmission which is represented by its current speed
 * and gear.
 * */
public interface Transmission {

  /**
   * Increases current speed by 2.
   * @return {@code Transmission object} with increased speed.
   * */
  Transmission increaseSpeed();

  /**
   * Decreases current speed by 2.
   * @return {@code Transmission object} with decreased speed.
   * */
  Transmission decreaseSpeed();

  /**
   * Returns the current gear in which the car transmission is presently.
   * @return current gear
   * */
  int getGear();

  /**
   * Returns the current speed in which the car transmission is presently.
   * @return current speed
   * */
  int getSpeed();

}
