package bignumber;

public class ElementNode implements ListOfDigits {

  int digit;
  ListOfDigits rest;

  ElementNode(int digit, ListOfDigits rest) {
    this.digit = digit;
    this.rest = rest;
  }

  @Override
  public int count() {
    return 0;
  }

  @Override
  public int countHelp(int acc) {
    return 0;
  }

  @Override
  public int length() {
    return 0;
  }

  @Override
  public BigNumber shiftLeft(int shifts) {
    return null;
  }

  @Override
  public BigNumber shiftRight(int shifts) {
    return null;
  }

  @Override
  public BigNumber addDigit(int digit) throws IllegalArgumentException {
    return null;
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
}