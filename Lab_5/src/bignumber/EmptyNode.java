package bignumber;

/**
 * Element Node.
 * */
public class EmptyNode implements ListOfDigits {

  @Override
  public int count() {
    return 0;
  }

  @Override
  public int countHelp(int acc) {
    return acc;
  }

  @Override
  public void addDigit(int digit) {
    throw new IllegalArgumentException("invalid");
  }

  @Override
  public int getDigitAt(int position) {
    throw new IllegalArgumentException("invalid");
  }

  @Override
  public int getDigitAtHelp(int acc, int position) {
    throw new IllegalArgumentException("invalid");
  }

  @Override
  public ListOfDigits add(ListOfDigits that, int carry) {
    if (that instanceof EmptyNode) {
      return new ElementNode(carry, this);
    }
    else {
      if (carry != 0) {
        that.addDigit(carry);
      }
      return that;
    }
  }

  @Override
  public ListOfDigits getLod() {
    return null;
  }

  @Override
  public int getDigit() {
    throw new IllegalArgumentException("invalid");
  }

  @Override
  public ListOfDigits getRest() {
    return null;
  }

  @Override
  public String toString() {
    return "";
  }
}
