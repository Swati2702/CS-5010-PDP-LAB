package transmission;

/**
 * AutomaticTransmission automatically determines the
 * current gear by the current speed of the car.
 * */
public class AutomaticTransmission implements Transmission {

  private final int speed;
  private final int gear;
  private final int threshold1;
  private final int threshold2;
  private final int threshold3;
  private final int threshold4;
  private final int threshold5;

  /**
   * Constructs an automatic transmission.
   * sets speed and gear to 0 initially.
   *
   * @param threshold1 - threshold for switching from gear 1 to gear 2
   * @param threshold2 - threshold for switching from gear 2 to gear 3
   * @param threshold3 - threshold for switching from gear 3 to gear 4
   * @param threshold4 - threshold for switching from gear 4 to gear 5
   * @param threshold5 - threshold for switching from gear 5 to gear 6
   * @throws IllegalArgumentException if any threshold value is below zero
   *     or if thresholds are not in increasing order
   * */
  public AutomaticTransmission(int threshold1, int threshold2, int threshold3,
                               int threshold4, int threshold5)throws IllegalArgumentException {
    if ((threshold1 <= 0 ) || (threshold2 <= 0 ) || (threshold3 <= 0)
            || (threshold4 <= 0 ) || (threshold5 <= 0)) {
      throw new IllegalArgumentException( "Negative speeds are not supported");
    }
    if ((threshold1 >= threshold2) || (threshold2 >= threshold3)
            || (threshold3 >= threshold4) || (threshold4 >= threshold5)) {
      throw new IllegalArgumentException(" Gear speeds are not correct");
    }
    this.threshold1 = threshold1;
    this.threshold2 = threshold2;
    this.threshold3 = threshold3;
    this.threshold4 = threshold4;
    this.threshold5 = threshold5;
    this.speed = 0;
    this.gear = 0;
  }

  /**
   * Constructs an automatic transmission.
   * sets gear according to the value of the speed.
   *
   * @param threshold1 - threshold for switching from gear 1 to gear 2
   * @param threshold2 - threshold for switching from gear 2 to gear 3
   * @param threshold3 - threshold for switching from gear 3 to gear 4
   * @param threshold4 - threshold for switching from gear 4 to gear 5
   * @param threshold5 - threshold for switching from gear 5 to gear 6
   * @param speed - current speed of transmission
   * @throws IllegalArgumentException if any threshold value is below zero
   * */

  private AutomaticTransmission(int threshold1, int threshold2, int threshold3,
                                int threshold4, int threshold5,
                                int speed) throws IllegalArgumentException {
    if ((threshold1 <= 0 ) || (threshold2 <= 0 ) || (threshold3 <= 0) || (threshold4 <= 0 )
            || (threshold5 <= 0)) {
      throw new IllegalArgumentException( "Negative speeds are not supported");
    }
    this.threshold1 = threshold1;
    this.threshold2 = threshold2;
    this.threshold3 = threshold3;
    this.threshold4 = threshold4;
    this.threshold5 = threshold5;
    this.speed = speed;
    if (speed == 0) {
      this.gear = 0;
    }
    else if (speed < threshold1) {
      this.gear = 1;
    }
    else if (speed < threshold2) {
      this.gear = 2;
    }
    else if (speed < threshold3) {
      this.gear = 3;
    }
    else if (speed < threshold4) {
      this.gear = 4;
    }
    else if (speed < threshold5) {
      this.gear = 5;
    }
    else {
      this.gear = 6;
    }

  }

  @Override
  public int getGear() {
    return this.gear;
  }

  @Override
  public int getSpeed() {
    return this.speed;
  }

  /**
   * Increases current speed by 2 and sets gear accordingly by calling the private constructor.
   * @return {@code AutomaticTransmission object} with increased speed and appropriate gear.
   * */
  @Override
  public Transmission increaseSpeed() {
    return new AutomaticTransmission(this.threshold1, this.threshold2,
            this.threshold3, this.threshold4, this.threshold5,this.speed + 2);

  }

  /**
   * Decreases current speed by 2 and sets gear accordingly by calling the private constructor.
   * @return {@code AutomaticTransmission object} with decreased speed and appropriate gear.
   * @throws IllegalStateException when speed is decreased below zero
   * */
  @Override
  public Transmission decreaseSpeed() throws IllegalStateException {
    if (this.speed - 2 < 0 ) {
      throw new IllegalStateException("Speed dropped below zero.");
    }
    return new AutomaticTransmission(this.threshold1, this.threshold2,
            this.threshold3, this.threshold4, this.threshold5,this.speed - 2);

  }

  @Override
  public String toString() {
    // Formats reading values in desired format and returns the value
    return String.format("Transmission (speed = %d, gear = %d)", this.speed, this.gear);

  }

}
