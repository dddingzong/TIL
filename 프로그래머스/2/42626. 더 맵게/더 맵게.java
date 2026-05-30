import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        
        for (int s : scoville) {
            pq.add(s);
        }
        
        while (pq.peek() < K) {
            if (pq.size() == 1) return -1;
            
            int sm1 = pq.poll();
            int sm2 = pq.poll();
            
            pq.add(sm1+sm2*2);
            answer++;
        }
        
        return answer;
    }
}