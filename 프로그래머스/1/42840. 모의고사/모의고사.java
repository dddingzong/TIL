import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        List<Integer> tmp = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int[] cnt = new int[3];
        
        int[] answer1 = new int[]{1,2,3,4,5};
        int[] answer2 = new int[]{2,1,2,3,2,4,2,5};
        int[] answer3 = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        for (int i=0;i<answers.length;i++) {
            int n = answers[i];
            if (n == answer1[i%answer1.length]) cnt[0]++;
            if (n == answer2[i%answer2.length]) cnt[1]++;
            if (n == answer3[i%answer3.length]) cnt[2]++;
        }
        
        for (int i=0;i<3;i++){
            max = Math.max(max, cnt[i]);
        }
        
        for (int i=0;i<3;i++){
            if (cnt[i] == max) {
                tmp.add(i);
            }
        }
        
        answer = new int[tmp.size()];
        
        for (int i=0;i<tmp.size();i++){
            answer[i] = tmp.get(i)+1;
        }
        
        
        return answer;
    }
}