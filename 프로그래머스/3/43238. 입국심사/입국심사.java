import java.util.*;

class Solution {
    
    static long left;
    static long right;
    
    public long solution(int n, int[] times) {
        long answer = 0;
        int max = Integer.MIN_VALUE;
        
        for (int time : times) {
            max = Math.max(max, time);
        }
        
        left = 1;
        right = (long)max * n;
        
        while (left <= right){
            long mid = (left + right) /2;
            if (simulate(mid,n,times)) {
                right = mid -1;
                answer = mid;
            } else {
                left = mid +1;
            }
        }

        return answer;
    }
    
    static boolean simulate(long time, int n, int[] times){
        long count = 0;
        
        for (int t : times) {
            count += time/t;
            if (count >= n) return true;
        }
        
        return false;
    }
}