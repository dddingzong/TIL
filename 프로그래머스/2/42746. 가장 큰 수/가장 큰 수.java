import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] arr = new String[numbers.length];
        
        for (int i=0;i<numbers.length;i++) {
            int number = numbers[i];
            arr[i] = Integer.toString(number);
        }
        
        Arrays.sort(arr, (a,b) -> (b+a).compareTo(a+b));
        
        for (String str : arr) {
            answer += str;
        }
        
        if (answer.substring(0,1).equals("0")) return "0";
        
        return answer;
    }
}