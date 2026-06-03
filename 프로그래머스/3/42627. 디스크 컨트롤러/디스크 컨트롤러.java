import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
 
        // 작업의 번호, 요청 시간, 소요 시간 저장 큐 - 대기 큐
        // 우선 순위: 소요시간이 짧은 것, 요청 시간이 짧은 것, 작업의 번호
        
        // 모든 요청 작업의 평균 반환 시간 return
        
        PriorityQueue<int[]> waitpq = new PriorityQueue<>((a,b) -> a[1] - b[1]); 

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if (a[2] == b[2] && a[1] == b[1]) {
                return a[0] - b[0];
            } else if (a[2] == b[2]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });
        
        for (int i = 0;i< jobs.length; i++) {       
            int[] cur = jobs[i];
            waitpq.add(new int[]{i, cur[0], cur[1]});
        }
        
        int total = 0;
        int cnt = 0;
        int clear = 0;
        
        while (clear != jobs.length) {
            
            while(!waitpq.isEmpty() && waitpq.peek()[1] <= cnt) {
                pq.add(waitpq.poll());
            }
              
            // 반환시간 : 작업 종료 시각 - 요청 시각
            
            if (!pq.isEmpty()) {
                int cur[] = pq.poll();

                int begin = cur[1];
                int time = cur[2];

                total += cnt+time-begin;
                System.out.println(total);
                clear++;
                cnt+=time;
                continue;
            }
            
            
            cnt++;
        }
        
        answer = total / jobs.length;
        
        return answer;
    }
}