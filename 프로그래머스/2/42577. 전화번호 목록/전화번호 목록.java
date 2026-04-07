import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;        
        Arrays.sort(phone_book);
        
        for (int i=0;i<phone_book.length-1;i++) {
            String cur = phone_book[i];
            if (phone_book[i+1].startsWith(cur)){
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}