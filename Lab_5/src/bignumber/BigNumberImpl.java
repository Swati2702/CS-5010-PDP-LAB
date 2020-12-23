package bignumber;

/**
 * Big Number Impl.
 * */
public class BigNumberImpl implements BigNumber {

  private ListOfDigits lod;

  /**
   * Constructor to create 0.
   * */
  public BigNumberImpl() {
    lod = new ElementNode();
  }

  /**
   * Constructor to create 0.
   * */
  public BigNumberImpl(String number) throws  IllegalArgumentException {
    if (!number.matches("[0-9]+")) {
      throw new IllegalArgumentException("invalid number");
    }
    StringBuilder stringBuilder = new StringBuilder(number);
    this.lod = new ElementNode(stringBuilder.reverse().toString());

  }

  @Override
  public int length() {
    return this.lod.count();
  }

  @Override
  public void shiftLeft(int shifts) {
    if (shifts > 0) {
      while (shifts > 0 ) {
        this.lod = new ElementNode(0, this.lod);
        shifts--;
      }
    }
    else if (shifts < 0 ) {
      shiftRight(-shifts);
    }


  }

  @Override
  public void shiftRight(int shifts) {
    if (shifts > 0 ) {
      if (this.length() == 1 && this.toString().equals("0")) {
        return;
      }
      while (shifts > 0) {
        this.lod = this.lod.getLod();
        shifts--;
      }
    }
    else if (shifts < 0 ) {
      shiftLeft(-shifts);
    }


  }

  @Override
  public void addDigit(int digit) throws IllegalArgumentException {
    if (digit < 0 || digit > 9) {
      throw new IllegalArgumentException(" digit should be between 0-9");
    }
    lod.addDigit(digit);

  }

  @Override
  public int getDigitAt(int position) throws IllegalArgumentException {
    return lod.getDigitAt(position);
  }

  @Override
  public BigNumber copy() {
    return new BigNumberImpl(lod.toString());
  }

  @Override
  public BigNumber add(BigNumber that) {
    //int length = that.toString().length();
    return new BigNumberImpl(lod.add(that.getLod(),0).toString());
  }

  @Override
  public ListOfDigits getLod() {
    return  lod;
  }

  @Override
  public String toString() {
    String s = this.lod.toString();
    int i = 0;
    while ( i < s.length() && s.charAt(i) == '0') {
      i += 1;
    }
    if ( i < s.length() ) {
      s = s.substring(i);
    } else {
      s = "0";
    }

    return s;
  }


  @Override
  public int compareTo(BigNumber that) {
    if (this.length() != that.length()) {
      return this.length() - that.length();
    }
    int i = 1;
    while (this.getDigitAt(this.length() - i) == this.getDigitAt(this.length() - i)) {
      i++;
    }

    return this.getDigitAt(this.length() - i) - that.getDigitAt(that.length() - i);
  }

}
