import java.util.*;

class Solution {
    
    static Queue<Integer> que;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // bfs
        boolean[] visited = new boolean[n];
        
        for (int i=0;i<n;i++) {
            if (visited[i]) continue;
            
            que = new LinkedList<>();
            que.add(i);
            visited[i] = true;
            
            while (!que.isEmpty()) {
                int curr = que.poll();
                
                int[] injectList = computers[curr];
                for (int j=0;j<n;j++) {
                    if (injectList[j]==0 || visited[j]) continue;
                    que.add(j);
                    visited[j] = true;
                    
                }   
            }  
            answer++;
            
        }        
        
        
        return answer;
    }
}