package lookandsay;

import java.math.BigInteger;

/**
 * Iterator.
 * */
public class LookAndSayIterator implements RIterator<BigInteger> {

  private static final BigInteger DEFAULT_SEED = new BigInteger("1");
  private static final BigInteger DEFAULT_END = new BigInteger("9".repeat(100));

  private final BigInteger end;
  private BigInteger curr;
  private BigInteger prevCurr;

  /**
   * Constructor.
   * */
  public LookAndSayIterator(BigInteger seed, BigInteger end) {
    if (seed.compareTo(new BigInteger("0")) < 0 || seed.compareTo(end) >= 0
            || seed.toString().contains("0")  ) {
      throw new IllegalArgumentException("Invalid seed");
    }
    this.end = end;
    this.curr = seed;
    this.prevCurr = seed;
  }

  /**
   * Constructor.
   * */
  public LookAndSayIterator(BigInteger seed) {
    this(seed, DEFAULT_END);
    if (seed.compareTo(new BigInteger("0")) < 0 || seed.compareTo(end) >= 0
            || seed.toString().contains("0")  ) {
      throw new IllegalArgumentException("Invalid seed");
    }
  }

  /**
   * Constructor.
   * */
  public LookAndSayIterator() {
    this(DEFAULT_SEED, DEFAULT_END);
  }

  @Override
  public boolean hasPrevious() {
    BigInteger a;
    if (prevCurr.toString().length() % 2 ==  0) {
      a = getPrev(prevCurr);
      return a.compareTo(DEFAULT_SEED) >= 0 ;
    }
    else {
      return false;
    }
    //return (curr.toString().length() % 2 == 0 && curr.toString().length() >= 2) ;
  }

  @Override
  public BigInteger prev() {
    curr = prevCurr;
    prevCurr = getPrev(prevCurr);
    return prevCurr;
  }

  private BigInteger getPrev(BigInteger curr)  {
    StringBuilder st = new StringBuilder();
    for (int i = 1;i < curr.toString().length();) {

      char co = (curr.toString().charAt(i - 1));
      int count = Character.getNumericValue(co);
      char letter = curr.toString().charAt(i);
      st.append(String.valueOf(letter).repeat(Math.max(0, count)));
      i = i + 2;
    }
    return new BigInteger(st.toString());
  }

  @Override
  public boolean hasNext() {
    return curr.compareTo(end) <= 0;
  }

  private BigInteger getNext() {
    // compute next value based on current, and return it, WITHOUT mutating anything

    StringBuilder newStr = new StringBuilder();
    int count = 1;
    char say  = this.curr.toString().charAt(0);

    for (int j = 1,len = curr.toString().length(); j < len; j++) {
      if (this.curr.toString().charAt(j) != say) {
        newStr.append(count).append(say);
        count = 1;
        say = this.curr.toString().charAt(j);
      }
      else {
        count++;
      }
    }
    newStr.append(count).append(say);
    return new BigInteger(newStr.toString());

  }


  @Override
  public BigInteger next() {
    prevCurr = curr;
    curr = getNext();
    return prevCurr;
  }

}