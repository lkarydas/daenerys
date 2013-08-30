import java.util.Arrays;


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
    
    System.out.println("\n\nString Permutations:");
    StringProblems.printPermutations("abcd");
    
    System.out.println("___________________________________________Interval Problems");
    IntervalProblems intervalProblems = new IntervalProblems();
    
    Interval[] intervals = new Interval[5];
    intervals[0] = new Interval(0, 1);
    intervals[1] = new Interval(3, 7);
    intervals[2] = new Interval(6, 19);
    intervals[3] = new Interval(27, 28);
    intervals[4] = new Interval(56, 57);
    
    intervalProblems.findUnion(intervals);
    intervalProblems.checkOverlap(intervals, new Interval(0, 4));

    System.out.println("___________________________________________Number Problems");
    NumberProblems numberProblems = new NumberProblems();
    System.out.println(numberProblems.isPower(1, 3));
    
    System.out.println("Fibonacci numbers: ");
    for (int i = 0; i < 10; i++) {
    	System.out.print(numberProblems.fibonacci(i) + " ");
    }
    System.out.println("");
    System.out.println("___________________________________________Array Problems");
    int[][] mat = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println(Arrays.deepToString(mat));
    int[][] out = ArrayProblems.rotateNinety(mat);
    System.out.println(Arrays.deepToString(out));
    ArrayProblems.rotateNinetyInPlace(mat);
    System.out.println(Arrays.deepToString(mat));
    
    ListElement<Integer> list = new ListElement<Integer>(1);
    ListElement<Integer> l2 = new ListElement<Integer>(2);
    ListElement<Integer> l3 = new ListElement<Integer>(3);
    ListElement<Integer> l4 = new ListElement<Integer>(4);
    list.setNext(l2);
    l2.setNext(l3);
    l3.setNext(l4);
    	
    list.print();
    
    ListProblems listProblems = new ListProblems();
    //list = listProblems.reverseIteratively(list);
    list = listProblems.reverseRecursively(list);
    list.print();
    
  }

}
