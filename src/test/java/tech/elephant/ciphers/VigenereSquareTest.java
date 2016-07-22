package tech.elephant.ciphers;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class VigenereSquareTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testEncipher() {
    thrown.expect(IllegalArgumentException.class);
    VigenereSquare.encipher("bad123", "abcxyz");
    thrown.expect(IllegalArgumentException.class);
    VigenereSquare.encipher("bad123", "abcxyz123");
    thrown.expect(IllegalArgumentException.class);
    VigenereSquare.encipher("bad123", "abcxyz123");

    String cipherText = VigenereSquare.encipher("lemon", "attackatdawn");
    assertTrue(cipherText.equals("LXFOPVEFRNHR"));
  }
}
