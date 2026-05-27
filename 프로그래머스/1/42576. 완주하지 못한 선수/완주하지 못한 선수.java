import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 정렬
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (int i=0;i<completion.length;i++) {
            if (!completion[i].equals(participant[i])) {
                answer = participant[i];
                break;
            }
        }
        
        if (answer.equals("")) {
            answer = participant[participant.length-1];
        }
        
        
        return answer;
    }
}