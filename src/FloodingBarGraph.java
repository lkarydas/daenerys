
/**
 * Solves the Flooding Bar Graph problem.
 */
public class FloodingBarGraph {
  
  int solve(int[] bars) {
    
    int[] leftMax = new int[bars.length];
    
    int curMax = 0;
    for (int i = 0; i < bars.length; i++) {
      if (curMax < bars[i]) {
        curMax = bars[i];
      }
      leftMax[i] = curMax;
    }
    
    int[] rightMax = new int[bars.length];
    curMax = 0;
    for (int i = bars.length - 1; i >=0; i--) {
      if (curMax < bars[i]) {
        curMax = bars[i];
      }
      rightMax[i] = curMax;
    }
    
    int sum = 0;
    for (int i = 1; i < bars.length - 1; i++) {
      sum += Math.max(Math.min(leftMax[i-1], rightMax[i+1]) - bars[i], 0);
    }
    
    return sum;
  }

}
