import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> tmpAnswer = new ArrayList<>();
        int n = progresses.length;
        int[] answer = {};
        int cycleCount = 0;

        
        Queue<Integer> que = new LinkedList<>();
        
        for (int i=0;i<n;i++) {
            que.add(i);
        }
        
        while (cycleCount != n){
            int cnt =0;
            
            for (int i=0; i < n; i++) {
                progresses[i] += speeds[i];
                
                if (progresses[i] >= 100) {
                    int cur = que.peek();
                    if (cur == i) {
                        cnt++;
                        que.poll();
                    }
                }
                
            }
            
            if (cnt !=0) {
                tmpAnswer.add(cnt);
            }
            
            cycleCount += cnt;
        }
        
        answer = new int[tmpAnswer.size()];
          
        for (int i=0;i<tmpAnswer.size();i++) {
            answer[i] = tmpAnswer.get(i);
        }
         
        return answer;
    }
}