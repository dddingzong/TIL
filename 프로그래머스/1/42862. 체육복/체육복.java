import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        
        for (int number : lost) {
            lostSet.add(number);
        }
        
        for (int number : reserve) {
            reserveSet.add(number);
        }
        
        for (int number : lost) {
            if (reserveSet.contains(number)) {
                lostSet.remove(number);
                reserveSet.remove(number);
            }
        }
        
                
        List<Integer> lostList = new ArrayList<>(lostSet);
        List<Integer> reserveList = new ArrayList<>(reserveSet);
        
        Collections.sort(reserveList, (a,b) -> Integer.compare(a,b));

        
        answer = n - lostSet.size();
        for (int i=0; i < reserveList.size(); i++) {
            
            int cur = reserveList.get(i);
            
            if (lostSet.contains(cur-1)) {
                lostSet.remove(cur-1);
                answer++;
            } else if (lostSet.contains(cur+1)) {
                lostSet.remove(cur+1);
                answer++;
            }
            
        }
        
        return answer;
    }
}