
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
    // reminder: check for null
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
}