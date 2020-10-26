package bst;

import java.util.ArrayList;
import java.util.List;

/**
 * A tree, much like a list, is made of several nodes.
 * An empty node does not contain any data, nor references to other nodes.
 * */
public class BSTGroupNode<T extends Comparable<T>> implements BSTNode<T> {

  private final T data;
  private BSTNode<T> left;
  private BSTNode<T> right;

  /**
   * Constructor.
   * */
  public BSTGroupNode(T data, BSTNode<T> left, BSTNode<T> right) {
    if (data == null || left == null || right == null) {
      throw new IllegalArgumentException("");
    }
    this.data = data;
    this.left = left;
    this.right = right;
  }

  @Override
  public int size() {
    return 1 + left.size() + right.size();
  }

  @Override
  public BSTNode<T> add(T obj) {
    if (data.compareTo(obj) < 0) {
      right = right.add(obj);
    } else if (data.compareTo(obj) > 0) {
      left = left.add(obj);
    }
    return this;
  }

  @Override
  public List<T> preOrder() {

    List<T> temp = new ArrayList<>();
    List<T> temp2 = left.preOrder();
    temp.add(data);
    if (!temp2.isEmpty()) {
      temp.addAll(temp2);
    }

    temp2 = right.preOrder();
    if (!temp2.isEmpty()) {
      temp.addAll(temp2);
    }
    return temp;
  }

  @Override
  public List<T> inOrder() {
    List<T> temp = new ArrayList<>();
    List<T> temp2 = left.inOrder();
    if (!temp2.isEmpty()) {
      temp.addAll(temp2);
    }
    temp.add(data);
    temp2 = right.inOrder();
    if (!temp2.isEmpty()) {
      temp.addAll(temp2);
    }
    return temp;
  }

  @Override
  public List<T> postOrder() {
    List<T> temp = new ArrayList<>();
    List<T> temp2 = left.postOrder();
    if (!temp2.isEmpty()) {
      temp.addAll(temp2);
    }

    temp2 = right.postOrder();
    if (!temp2.isEmpty()) {
      temp.addAll(temp2);
    }
    temp.add(data);
    return temp;
  }

  @Override
  public boolean present(T obj) {
    if (data.equals(obj)) {
      return true;
    }

    else {
      return (left.present(obj) || right.present(obj));
    }
  }

  @Override
  public int height() {
    if (left.height() >= right.height()) {
      return 1 + left.height();
    }
    else {
      return 1 + right.height();
    }

  }


}