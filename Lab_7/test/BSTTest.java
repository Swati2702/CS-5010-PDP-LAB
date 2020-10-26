import org.junit.Test;

import bst.BST;
import bst.BSTImpl;

import static org.junit.Assert.assertEquals;

/**
 *Test.
 * */
public class BSTTest {

  @Test
  public void testAdd() {
    BST<String> bst = new BSTImpl<>();
    bst.add("abc");
    assertEquals(1, bst.size());
  }

  @Test
  public void testPreOrder() {
    BST<Integer> bst = new BSTImpl<>();
    bst.add(7);
    bst.add(3);
    bst.add(1);
    bst.add(10);
    bst.add(8);
    bst.add(9);
    bst.add(12);
    assertEquals("", bst.preOrder());
  }

  @Test
  public void testPresent() {
    BST<String> bst = new BSTImpl<>();
    bst.add("a");
    bst.add("b");
    bst.add("c");
    assertEquals(true, bst.present("a"));
  }

  @Test
  public void testInorder() {
    BST<Integer> bst = new BSTImpl<>();
    bst.add(7);
    bst.add(3);
    bst.add(1);
    bst.add(10);
    bst.add(8);
    bst.add(9);
    bst.add(12);
    assertEquals("", bst.inOrder());
  }

  @Test
  public void testMinimum() {
    BST<Integer> bst = new BSTImpl<>();
    bst.add(7);
    bst.add(3);
    bst.add(1);
    bst.add(10);
    bst.add(8);
    bst.add(9);
    bst.add(12);
    assertEquals("", bst.maximum());
  }

}
