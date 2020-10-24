import org.junit.Before;
import org.junit.Test;

import bignumber.BigNumber;
import bignumber.BigNumberImpl;

import static org.junit.Assert.assertEquals;

/**
 * Tests for big number.
 * */
public class BigNumberTests {

  private BigNumber bigNumber;

  @Before
  public void setup() {
    bigNumber = new BigNumberImpl("1432");
  }

  @Test
  public void testToString() {

    assertEquals("1432", bigNumber.toString());
  }

  @Test
  public void testLength() {
    assertEquals(4, bigNumber.length());
  }

  @Test
  public void testGetDigitAt() {
    int digit = bigNumber.getDigitAt(1);
    assertEquals(3, digit);
  }

  @Test
  public void testLeftShift() {
    bigNumber.shiftLeft(1);
    assertEquals("14320", bigNumber.toString());
  }

  @Test
  public void testRightShift() {
    bigNumber.shiftRight(1);
    assertEquals("143", bigNumber.toString());
  }

  @Test
  public void testRightShiftZero() {
    bigNumber = new BigNumberImpl();
    bigNumber.shiftRight(10);
    assertEquals("0", bigNumber.toString());
  }

  @Test
  public void testAddDigit() {
    bigNumber = new BigNumberImpl("999");
    bigNumber.addDigit(9);
    assertEquals("1008", bigNumber.toString());
  }

  @Test
  public void testCopy() {
    BigNumber copy = bigNumber.copy();
    assertEquals(copy.toString(), bigNumber.toString());
  }

  @Test
  public void testAdd() {
    BigNumber newA = new BigNumberImpl("480077");
    assertEquals("481509", bigNumber.add(newA).toString());
  }


}
