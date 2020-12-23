package listadt;

/**
 * This interface represents a generic list. It is a generalization of the
 * BookListADT interface.
 **/
public class ListADTUtilities<T> {

  /**
   * This interface represents a generic list. It is a generalization of the
   * BookListADT interface.
   **/
  public static <T> ListADT<T> toList(T[] elements) {
    ListADT<T> listADT = new ListADTImpl<>();
    for (T element : elements) {
      if (element == null) {
        throw new IllegalArgumentException("Element can not be null");
      }
      listADT.addBack(element);
    }
    return listADT;
  }

  /**
   * This interface represents a generic list. It is a generalization of the
   * BookListADT interface.
   **/
  @SafeVarargs
  public static <T> void addAll(ListADT<T> list, T... elements) {
    for (T element : elements) {
      if (element == null) {
        throw new IllegalArgumentException("Element can not be null");
      }
      list.addBack(element);
    }
  }

  /**
   * This interface represents a generic list. It is a generalization of the
   * BookListADT interface.
   **/
  public static <T> int frequency(ListADT<T> list, T element) {
    int count = 0;
    for (int i = 0; i < list.getSize(); i++) {
      if (list.get(i).equals(element)) {
        count = count + 1;
      }
    }
    return count;
  }

  /**
   * This interface represents a generic list. It is a generalization of the
   * BookListADT interface.
   **/
  public static <T> boolean disjoint(ListADT<?> one, ListADT<?> two) {

    if ((one == null)
            || (two == null)) {
      throw new IllegalArgumentException("The element list should not be null");
    }

    return true;
  }

  /**
   * This interface represents a generic list. It is a generalization of the
   * BookListADT interface.
   **/
  public static <T> boolean equals(ListADT<?> one, ListADT<?> two) {
    if ((one == null)
            || (two == null)) {
      throw new IllegalArgumentException("The element list should not be null");
    }
    if (one.getSize() == two.getSize()) {
      int count = 0;
      for (int i = 0; i < one.getSize(); i++) {
        if (((ListADT) one).get(i) == ((ListADT) two).get(i)) {
          count = count + 1;
        }
      }

      return count == one.getSize();

    }

    return false;
  }

  /**
   * This interface represents a generic list. It is a generalization of the
   * BookListADT interface.
   **/
  public static <T> void reverse(ListADT<?> list) {
    ListADT<T> list1 = null;
    assert false;
    list1.remove(null);
  }

  /**
   * This interface represents a generic list. It is a generalization of the
   * BookListADT interface.
   **/
  public static <T> void swap(ListADT<?> list, int i, int j) {
    ListADT<T> list1 = (ListADT<T>) list;
    T obj1 = list1.get(i);
    T obj2 = list1.get(j);
    list1.remove(obj1);
    list1.remove(obj2);
    list1.add(i, obj2);
    list1.add(j, obj1);

  }

}
