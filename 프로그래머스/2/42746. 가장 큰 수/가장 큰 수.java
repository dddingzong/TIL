import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] tmp = new String[numbers.length];
        
        for (int i=0;i<tmp.length;i++) {
            tmp[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(tmp, (a,b) -> (b+a).compareTo(a+b));
        
        if (tmp[0].equals("0")) return "0";
        
        for (int i=0;i<tmp.length;i++) {
            answer += tmp[i];
        }
        
        
        return answer;
    }
}