package lookandsay;

import java.util.Iterator;

/**
 * Iterator.
 * */
public interface RIterator<T>  extends Iterator<T> {
  /**
   * Constructor.
   * */
  boolean hasPrevious();

  /**
   * Constructor.
   * */
  T prev();
}