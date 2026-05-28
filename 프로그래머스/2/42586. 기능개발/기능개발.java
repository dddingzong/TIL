import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        int n = progresses.length;
        int next = 0;
        boolean[] visited = new boolean[n];
        List<Integer> answerList = new ArrayList<>();
        
        while (next != n) {
            // 제거부터 진행
            if (!pq.isEmpty() && pq.peek() == next) {
                int cnt = 0;
                while(!pq.isEmpty()){
                    if (pq.peek() != next) break;
                    int cur = pq.poll();
                    cnt++;
                    next++;
                }
                answerList.add(cnt);
            }
            
            for (int i=0;i<n;i++) { 
                progresses[i] += speeds[i];
            }
            
            
            // 100이 있는지 확인
            for (int i=0;i<n;i++) {
                if (progresses[i] >= 100 && visited[i] == false) {
                    pq.add(i);
                    visited[i] = true;
                }
            }
            
            
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i=0;i<answer.length;i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}