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
}