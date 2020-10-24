import org.junit.Test;

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

}
