package tech.elephant.ciphers;

import java.util.regex.Pattern;

/**
 * Vigenère Cipher as per https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher.
 */
public class VigenereSquare {

  private static final int A_VAL = (int) 'A';
  private static final int MAX_CHARS = 26;
  private static final Pattern ONLY_LETTERS =  Pattern.compile("^[a-zA-Z]+$");

  /**
   * Loop over the key while enciphering each letter of plaintext such that each letter of the key is the key for a
   * CaesarShift for just that letter of the plaintext.
   * e.g.
   * key:       LEMONLEMONLE
   * plaintext: ATTACKATDAWN
   * ciphertext:LXFOPVEFRNHR
   *
   * @param key has to be within 26 letters of english alphabet
   * @param plainText only 26 letters of english alphabet
   * @return ciphertext
   */
  public static String encipher(String key, String plainText) {
    if (!ONLY_LETTERS.matcher(key).matches() || !ONLY_LETTERS.matcher(plainText).matches()) {
      throw new IllegalArgumentException("key and plaintext can only contain the 26 letters of English alphabet");
    }

    String uKey = key.toUpperCase();
    String uPlainText = plainText.toUpperCase();

    StringBuilder cipherText = new StringBuilder();
    for (int i=0; i < uPlainText.length(); i++) {
      int offset = (int)uKey.charAt(i % uKey.length()) - A_VAL;
      char c = (char)((((int)uPlainText.charAt(i) + offset - A_VAL) % MAX_CHARS) + A_VAL);
      cipherText.append(c);
    }

    return cipherText.toString();
  }

  /**
   * Prints cipher text, in upper case with spaces preserved, given key and plaintext respectively.
   * @param args key, plaintext
   */
  public static void main(String[] args) {
    System.out.println(encipher(args[0], args[1]));
  }
}
