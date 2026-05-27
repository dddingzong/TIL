import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        // for (String phone : phone_book) {
        //     System.out.println(phone);
        // }
        
        for (int i=0;i<phone_book.length-1;i++) {
            String phone = phone_book[i];
            String nextPhone = phone_book[i+1];
            if (nextPhone.startsWith(phone)) {
                return false;
            }
        }
        
        return true;
    }
}