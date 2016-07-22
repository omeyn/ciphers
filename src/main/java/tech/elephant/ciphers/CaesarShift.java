package tech.elephant.ciphers;

/**
 * Caesar Cipher as per https://en.wikipedia.org/wiki/Caesar_cipher.
 */
public class CaesarShift {

  private static final int A_VAL = (int)'A';
  private static final int MAX_CHARS = 26;

  public static String encipher(char key, String plainText) {
    return encipher((int)String.valueOf(key).toUpperCase().charAt(0)-A_VAL, plainText);
  }

  public static String encipher(int offset, String plainText) {
    if (offset < 1 || offset > 25) {
      throw new IllegalArgumentException("Offset must be between 1 and 25");
    }
    StringBuilder cipherText = new StringBuilder();
    String uPlainText = plainText.toUpperCase();

    for (int i=0; i < uPlainText.length(); i++) {
      // wrap around so that z + 1 becomes a
      char c = (char)((((int)uPlainText.charAt(i) + offset - A_VAL) % MAX_CHARS) + A_VAL);
      cipherText.append(c);
    }
    return cipherText.toString();
  }

  /**
   * Prints cipher text, in upper case with spaces preserved, given single character key and plaintext respectively.
   * @param args character (key), plaintext
   */
  public static void main(String[] args) {
    System.out.println(encipher(args[0].charAt(0), args[1]));
  }
}
