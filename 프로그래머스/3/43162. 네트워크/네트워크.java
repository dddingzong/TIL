import java.util.*;

class Solution {    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        for (int i=0;i<n;i++) {
            if (visited[i] == true) continue;
            que.add(i);
            visited[i] = true; 
            
            while (!que.isEmpty()) {
                int cur = que.poll();
                int[] inject = computers[cur];
                for (int j=0;j<inject.length;j++) {
                    if (visited[j] == true || inject[j] ==0) continue;
                    que.add(j);
                    visited[j] = true;
                }
                
            }
            answer++;
        }
        
        return answer;
    }
}