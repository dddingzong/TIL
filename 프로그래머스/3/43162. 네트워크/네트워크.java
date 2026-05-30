import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for (int i=0;i<n;i++) {
            if (visited[i] == true) continue;
            dfs(i,computers);
            answer++;
        }
        
        return answer;
    }
    
    static void dfs(int i, int[][] computers) {
        visited[i] = true;
        
        int[] cur = computers[i];
        for(int j=0;j<cur.length;j++) {
            if (visited[j] == true || cur[j] == 0) continue;
            dfs(j,computers);
        }
        
    }
    
}