
/**
 * TODO: Insert description here. (generated by lkary)
 */
public class CodePracticeMain {


  public static void main(String[] args) {


    String[] strings = { "abcdef", " 78032soa", "I hope this helps.", "78032soa3"};

    for (int i = 0; i < strings.length; i++) {
      System.out.println("String: " + strings[i] + " " + 
          StringProblems.hasAllUniqueCharacters2(strings[i]));
      System.out.println("String: " + strings[i] + " " + StringProblems.reverseString(strings[i]));
    }
    
    int[] bars = {2, 3, 4, 3, 2, 6, 4, 9, 1};
    
    System.out.print("Water: " + new FloodingBarGraph().solve(bars));

  }

}
