package bst;

import java.util.List;

/**
 * add.
 * */
public class BSTImpl<T extends Comparable<T>> implements BST<T> {

  private BSTNode<T> root;

  /**
   * add.
   * */
  public BSTImpl() {
    root = new BSTLeafNode<>();
  }

  @Override
  public void add(T obj) {
    root = root.add(obj);
  }

  @Override
  public int size() {
    return root.size();
  }

  @Override
  public boolean present(T obj) {
    return root.present(obj);
  }

  @Override
  public T minimum() {
    List<T> order = root.inOrder();
    if (order.size() == 0) {
      return null;
    }
    return order.get(0);
  }

  @Override
  public T maximum() {
    List<T> order = root.inOrder();
    if (order.size() == 0) {
      return null;
    }
    return order.get(order.size() - 1);
  }

  @Override
  public String preOrder() {
    List<T> order = root.preOrder();

    String s = "[";

    for (T data: order) {

      s = s.concat(data.toString());
      s = s.concat(" ");
    }
    s = s.stripTrailing();
    s = s.concat("]");
    return s;
  }

  @Override
  public String inOrder() {
    List<T> order = root.inOrder();

    String s = "[";

    for (T data: order) {

      s = s.concat(data.toString());
      s = s.concat(" ");
    }
    s = s.stripTrailing();
    s = s.concat("]");
    return s;
  }

  @Override
  public String postOrder() {
    List<T> order = root.postOrder();

    String s = "[";

    for (T data: order) {

      s = s.concat(data.toString());
      s = s.concat(" ");
    }
    s = s.stripTrailing();
    s = s.concat("]");
    return s;
  }

  @Override
  public int height() {
    return root.height();
  }

  @Override
  public String toString() {
    List<T> order = root.inOrder();
    String s = "[";

    for (T data: order) {

      s = s.concat(data.toString());
      s = s.concat(" ");
    }
    s = s.stripTrailing();
    s = s.concat("]");
    return s;

  }

}