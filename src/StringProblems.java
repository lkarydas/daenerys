import java.util.HashMap;


/**
 * Practice problems. 
 */
public class StringProblems {

  /**
   * Problem:
   * Implement an algorithm to determine if a string has all unique characters.
   * @param string the input string.
   * 
   * First attempt, use a hash map.
   */
  public static boolean hasAllUniqueCharacters1(String string) {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    char character;
    for (int i = 0; i < string.length(); i++) {
      character = string.charAt(i);
      if (map.containsKey(character)) {
        return false;
      } else {
        map.put(string.charAt(i), 0);
      }
    }
    return true;
  }
  
  /**
   * Problem:
   * Implement an algorithm to determine if a string has all unique characters.
   * @param string the input string.
   * 
   * Second attempt, we don't really need a hash map. Just an array will do.
   */
  public static boolean hasAllUniqueCharacters2(String string) {
    // Assuming ASCII characters (256 possible values)
    // otherwise, if 16-bit Unicode, we need a bigger array (2^16 = 65536)
    boolean table[] = new boolean[256];
    // No need to initialize since the default value for boolean (primitive) is 
    // false
    int value;
    for (int i = 0; i < string.length(); i++) {
      value = string.charAt(i);
      if (table[value]) {
        return false;
      } else {
        table[value] = true;
      }
    }
    return true;
  }

}
