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
    return false;
  }

  @Override
  public T minimum() {
    return null;
  }

  @Override
  public T maximum() {
    return null;
  }

  @Override
  public String preOrder() {
    return root.preOrder(); // have root.preOrder return List<T>, then convert to String
  }

  @Override
  public String inOrder() {
    return null;
  }

  @Override
  public String postOrder() {
    return null;
  }

  @Override
  public int height() {
    return 0;
  }
}