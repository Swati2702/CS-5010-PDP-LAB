package priority;

/**
 * Hello.
 * */
public interface MinMaxPriorityQueue<T> {

  /**
   * Hello.
   * */
  void add(T item, int priority);

  /**
   * Hello.
   * */
  T minPriorityItem();

  /**
   * Hello.
   * */
  T maxPriorityItem();

}
