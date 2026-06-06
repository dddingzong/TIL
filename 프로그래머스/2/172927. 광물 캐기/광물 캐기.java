import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        PriorityQueue<int[]> score = 
            new PriorityQueue<>((a,b) -> b[0] - a[0]);
        
        int totalPick = picks[0] + picks[1] + picks[2];
        int limit = Math.min(minerals.length, totalPick * 5);
        
        for (int i=0;i<limit;i+=5) {
            int sc = 0;
            for (int j=i;j<minerals.length && j<i+5;j++) {
                if (minerals[j].equals("diamond")) {
                    sc += 25;
                } else if (minerals[j].equals("iron")) {
                    sc += 5;
                } else {
                    sc +=1;
                }
            }
            score.add(new int[]{sc,i});
        }
        
        int stoneP = picks[2];
        int ironP = picks[1];
        int diamondP = picks[0];
        
        while (!score.isEmpty()) {
            int[] cur = score.poll();
            int index = cur[1];
            
            // System.out.println(cur[0] + ", " + cur[1]);
            // System.out.println(diamondP + ", " + ironP + ", " + stoneP);
            
            if (diamondP != 0) {
                int p =0;
                diamondP--;
                for (int i=index; i<minerals.length && i<index+5;i++) {
                    p++;
                }
                answer+=p;
            } else if (ironP != 0) {
                int p = 0;
                for (int i=index; i<minerals.length && i<index+5;i++) {
                    if (minerals[i].equals("diamond")) {
                        p += 5;
                    } else if (minerals[i].equals("iron")) {
                        p += 1;
                    } else {
                        p +=1;
                    }
                }
                ironP--;
                answer += p;   
            } else if (stoneP != 0) {
                int p = 0;
                for (int i=index; i<minerals.length && i<index+5;i++) {
                    if (minerals[i].equals("diamond")) {
                        p += 25;
                    } else if (minerals[i].equals("iron")) {
                        p += 5;
                    } else {
                        p +=1;
                    }
                }
                stoneP--;
                answer += p;   
            }
            // System.out.println("answer = " + answer);
            
        }

        
        return answer;
    }
}