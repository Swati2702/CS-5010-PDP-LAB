
/**
 * add.
 * */
interface BSTNode<T extends Comparable<T>> {
  int size();

  BSTNode<T> add(T obj);

  String preOrder();


}