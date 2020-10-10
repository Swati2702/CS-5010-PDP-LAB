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
   *  Returns the number of digits in this number.
   * */
  int length();

  /**
   * Takes the number of shifts as an argument and shifts this number to the
   * left by that number. A negative number of left-shifts will correspond to those many right shifts.
   * */
  BigNumber shiftLeft(int shifts);

  /**
   * takes the number of shifts as an argument and shifts this number
   * to the right by that number. The number 0 can be right-shifted any positive
   * number of times, yielding the same number 0. A negative number of right-shifts
   * will correspond to those many left shifts.
   * */
  BigNumber shiftRight(int shifts);

  /**
   * Takes a position as an argument and returns the digit at that position. Positions start at 0
   * (rightmost digit). This method throws an IllegalArgumentException if an invalid position
   * is passed.
   *
   */
  BigNumber addDigit(int digit) throws IllegalArgumentException;

  /**
   * Takes a position as an argument and returns the digit at that position. Positions start at 0
   * (rightmost digit). This method throws an IllegalArgumentException if an invalid
   * position is passed.
   * */
  int getDigitAt(int position);

  /**
   * Returns an identical and independent copy of this number.
   * */
  BigNumber copy();

  /**
   * Takes another BigNumber and
   * returns the sum of these two numbers. This operation does not change either number.
   * */
  BigNumber add( BigNumber that);

  /**
   * Create and return a string that can be used to print this list.
   *
   * @return a string representing this list.
   */
  String toString();

}
