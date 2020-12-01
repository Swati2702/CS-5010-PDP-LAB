package bignumber;

/**
 * Element Node.
 * */
public class ElementNode implements ListOfDigits {

  int digit;
  ListOfDigits rest;

  /**
   * Element Node.
   * */
  ElementNode() {
    this.digit = 0;
    this.rest = new EmptyNode();
  }

  /**
   * Element Node.
   * */
  ElementNode(String number) {

    ListOfDigits empty = new EmptyNode();
    for (int i = number.length() - 1; i > 0 ; i--) {
      empty = new ElementNode( Integer.parseInt(String.valueOf(number.charAt(i))), empty);
    }
    this.digit = Integer.parseInt(String.valueOf(number.charAt(0)));
    this.rest = empty;

  }

  ElementNode(int number, ListOfDigits lod) {
    this.digit = number;
    this.rest = lod;
  }

  @Override
  public int count() {
    return countHelp(0);
  }

  @Override
  public int countHelp(int acc) {
    return this.rest.countHelp(1 + acc);
  }


  @Override
  public void addDigit(int digit) {
    this.digit += digit;
    if (this.digit > 9 ) {
      this.digit = this.digit % 10;
      if (this.rest instanceof EmptyNode) {
        this.rest = new ElementNode("1");
      }
      else {
        this.rest.addDigit(1);
      }

    }
  }

  @Override
  public int getDigitAt(int position) {
    return getDigitAtHelp(0, position);
  }

  @Override
  public int getDigitAtHelp(int acc, int position) {

    if (position == acc) {
      return this.digit;
    }
    return this.rest.getDigitAtHelp(1 + acc, position);
  }

  @Override
  public ListOfDigits add(ListOfDigits that, int carry) {
    this.digit += that.getDigit() + carry;
    if (that.getRest() instanceof EmptyNode) {
      if (this.rest instanceof  EmptyNode && this.digit / 10 != 0) {
        this.rest = new ElementNode(this.digit / 10, this.rest);
      }
      else {
        if (this.digit / 10 != 0) {
          this.rest.addDigit(this.digit / 10);
        }
      }
    }
    else {
      this.rest = this.rest.add(that.getRest(), this.digit / 10);
    }
    this.digit %= 10;
    return this;
  }

  @Override
  public ListOfDigits getLod() {
    return rest;
  }

  @Override
  public int getDigit() {
    return digit;
  }

  @Override
  public ListOfDigits getRest() {
    return rest;
  }

  @Override
  public String toString() {
    return rest.toString() + digit;
  }

}
