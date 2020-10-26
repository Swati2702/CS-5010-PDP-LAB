package bst;

import java.util.List;

/**
 * add.
 * */
interface BSTNode<T extends Comparable<T>> {
  int size();

  BSTNode<T> add(T obj);

  List<T> preOrder();


  List<T> inOrder();

  List<T> postOrder();

  boolean present(T obj);

  int height();
}