package bignumber;

/**
 * This interface represents all the operations to be supported by a list of
 * digits.
 */
public interface ListOfDigits {


  /**
   * Return the number of books in this list.
   *
   * @return the size of this list
   */
  int count();

  /**
   * Helper for the count method.
   *
   * @param acc the accumulator
   * @return the count from here
   */
  int countHelp(int acc);


  /**
   * Takes a position as an argument and returns the digit at that position. Positions start at 0
   * (rightmost digit).
   *
   */
  void addDigit(int digit);

  /**
   * Takes a position as an argument and returns the digit at that position. Positions start at 0
   * (rightmost digit). This method throws an IllegalArgumentException if an invalid
   * position is passed.
   * */
  int getDigitAt(int position);

  /**
   * Helper for the getDigitAt method.
   * Takes a position as an argument and returns the digit at that position. Positions start at 0
   * (rightmost digit). This method throws an IllegalArgumentException if an invalid
   * position is passed.
   * */
  int getDigitAtHelp(int acc, int position);

  /**
   * Takes another BigNumber and
   * returns the sum of these two numbers. This operation does not change either number.
   * */
  ListOfDigits add( ListOfDigits that, int carry);

  /**
   * Create and return a string that can be used to print this list.
   *
   * @return a string representing this list.
   */
  String toString();

  /**
   * Return lod.
   * */
  ListOfDigits getLod();

  int getDigit();

  ListOfDigits getRest();
}
