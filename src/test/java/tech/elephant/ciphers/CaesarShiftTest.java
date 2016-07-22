package tech.elephant.ciphers;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class CaesarShiftTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testIntKey() {
    thrown.expect(IllegalArgumentException.class);
    CaesarShift.encipher(0, "abcxyz");
    thrown.expect(IllegalArgumentException.class);
    CaesarShift.encipher(26, "abcxyz");

    String cipherText = CaesarShift.encipher(2, "abcxyz");
    assertTrue(cipherText.equals("CDEZAB"));
    cipherText = CaesarShift.encipher(25, "abcxyz");
    assertTrue(cipherText.equals("ZABWXY"));
  }

  @Test
  public void testCharKey() {
    thrown.expect(IllegalArgumentException.class);
    CaesarShift.encipher('A', "abcxyz");
    thrown.expect(IllegalArgumentException.class);
    CaesarShift.encipher('1', "abcxyz");

    String cipherText = CaesarShift.encipher('C', "abcxyz");
    assertTrue(cipherText.equals("CDEZAB"));
    cipherText = CaesarShift.encipher('Z', "ABCXYZ");
    assertTrue(cipherText.equals("ZABWXY"));
  }
}
