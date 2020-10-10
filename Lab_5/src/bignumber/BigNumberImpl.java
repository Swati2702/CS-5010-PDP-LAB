package bignumber;

public class BigNumberImpl implements BigNumber, Comparable<BigNumber> {

  private ListOfDigits lod;

  /**
   * Constructor to create 0.
   * */
  public BigNumberImpl() {


  }

  /**
   * Constructor to create 0.
   * */
  public BigNumberImpl(String number) throws  IllegalArgumentException {
    if (!number.matches("[0-9]+") || number.charAt(0) == '0') {
      throw new IllegalArgumentException("invalid number");
    }

  }
  @Override
  public int length() {
    return 0;
  }

  @Override
  public void shiftLeft(int shifts) {

  }

  @Override
  public void shiftRight(int shifts) {

  }

  @Override
  public void addDigit(int digit) throws IllegalArgumentException {

  }

  @Override
  public int getDigitAt(int position) {
    return 0;
  }

  @Override
  public BigNumber copy() {
    return null;
  }

  @Override
  public BigNumber add(BigNumber that) {
    return null;
  }

  @Override
  public String toString() {
    return String.format("%s", "mmmmm");
  }


  @Override
  public int compareTo(BigNumber that) {
    return 0;
  }


}
