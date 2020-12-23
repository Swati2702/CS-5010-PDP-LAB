import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import lookandsay.LookAndSayIterator;
import lookandsay.RIterator;
import org.junit.Test;

/**
 * Test.
 * */
public class LookAndSayTest {

  @Test
  public void testBasic() {
    RIterator<BigInteger> it = new LookAndSayIterator(new BigInteger("112321"));
    assertTrue(it.hasNext());
    assertEquals(new BigInteger("2112131211"), it.next());
  }

  @Test
  public void testPrev() {
    RIterator<BigInteger> it = new LookAndSayIterator(new BigInteger("111213"));
    assertTrue(it.hasPrevious());
    assertEquals(new BigInteger("123"), it.prev());
  }
}