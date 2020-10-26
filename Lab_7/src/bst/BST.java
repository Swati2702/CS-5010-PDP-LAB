package bst;

/**
 * BST.
 * */
public interface BST<T extends  Comparable<T>> {

  /**
   * add.
   * */
  void add(T obj);

  /**
   * add.
   * */
  int size();

  /**
   * add.
   * */
  boolean present( T obj);

  /**
   * add.
   * */
  T minimum();

  /**
   * add.
   * */
  T maximum();

  /**
   * add.
   * */
  String preOrder();

  /**
   * add.
   * */
  String inOrder();

  /**
   * add.
   * */
  String postOrder();

  /**
   * add.
   * */
  int height();


}
