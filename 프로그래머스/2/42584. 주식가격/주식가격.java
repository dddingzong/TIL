import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<int[]> stack = new Stack<>();
        
        int time = 0;
        for (int i=0;i<prices.length;i++) {
            
            if (stack.isEmpty()) {
                stack.push(new int[]{prices[i], time, i});
                time++;   
                continue;
            }
                
            while (!stack.isEmpty() && stack.peek()[0] > prices[i]) {
                int[] curr = stack.pop();
                answer[curr[2]] =  time - curr[1];
            }
            
            stack.push(new int[]{prices[i], time, i});
            
            time++;    
        }
        
        
        for (int[] curr : stack) {
            answer[curr[2]] =  time - curr[1] -1;
        }
        
        
        return answer;
    }
}