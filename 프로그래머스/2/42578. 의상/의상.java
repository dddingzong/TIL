import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        Map<String, Integer> hashMap = new HashMap<>();
        
        for(int i = 0; i < clothes.length;i++) {
            hashMap.put(clothes[i][1], 
                        hashMap.getOrDefault(clothes[i][1],0)+1);
        }
        
        Collection<Integer> values = hashMap.values();
        answer = 1;
        for(int value: values) {
            answer *= value+1;
        }
        
        return answer-1;
    }
}