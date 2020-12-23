package priority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * Hello.
 */
public class MinMaxPriorityQueueImpl<T>
        extends TreeMap<Integer, List<T>>
        implements MinMaxPriorityQueue<T> {


  @Override public void add(T item, int priority) {
    if (containsKey(priority)) {
      List<T> itemList = get(priority);
      itemList.add(item);
    } else {
      put(priority, new ArrayList<>(Collections.singletonList(item)));
    }
  }

  @Override public T minPriorityItem() {
    if (firstEntry() == null) {
      return null;
    } else {
      List<T> itemList = firstEntry().getValue();
      if (itemList.size() > 1) {
        T result = itemList.get(itemList.size() - 1);
        itemList.remove(itemList.size() - 1);
        return result;
      } else {
        return pollFirstEntry().getValue().get(0);
      }
    }
  }

  @Override public T maxPriorityItem() {
    if (lastEntry() == null) {
      return null;
    } else {
      List<T> itemList = lastEntry().getValue();
      if (itemList.size() > 1) {
        T result = itemList.get(itemList.size() - 1);
        itemList.remove(itemList.size() - 1);
        return result;
      } else {
        return pollLastEntry().getValue().get(0);
      }
    }
  }
}