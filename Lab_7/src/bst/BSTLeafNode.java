package bst;

import java.util.ArrayList;
import java.util.List;

/**
 * add.
 * */
public class BSTLeafNode<T extends Comparable<T>> implements BSTNode<T> {

  @Override
  public int size() {
    return 0;
  }

  @Override
  public BSTNode<T> add(T obj) {
    return new BSTGroupNode<>(obj, this, this);
  }

  @Override
  public List<T> preOrder() {
    List<T> temp = new ArrayList<>();
    return temp;
  }

  @Override
  public List<T> inOrder() {
    List<T> temp = new ArrayList<>();
    return temp;
  }

  @Override
  public List<T> postOrder() {
    List<T> temp = new ArrayList<>();
    return temp;
  }

  @Override
  public boolean present(T obj) {
    return false;
  }

  @Override
  public int height() {
    return 0;
  }


}