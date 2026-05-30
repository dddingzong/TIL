import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        for (int num : lost) {
            lostSet.add(num);
        }
        
        for (int num : reserve) {
            reserveSet.add(num);
        }
        
        Set<Integer> bothSet =  new HashSet<>();
        
        for (int num : reserveSet) {
            if (lostSet.contains(num)) {
                bothSet.add(num);
            }
        }
        
        for (int num : bothSet) {
            lostSet.remove(num);
            reserveSet.remove(num);
        }
        
       
    
        int[] arr = new int[n];
        
        // 0 잃어버린 사람, 1 해당 X, 2 여분
        for (int i=0;i<n;i++) {
            if (lostSet.contains(i+1)) {
                arr[i] = 0;
            } else if (reserveSet.contains(i+1)) {
                arr[i] = 2;
                answer++;
            } else {
                arr[i] = 1;
                answer++;
                
            }
        }
        
        // for (int i=0;i<max;i++) {
        //     System.out.print(arr[i] + ", ");
        // }
        
        for (int i=0;i<n;i++) {
            if (arr[i] == 1 | arr[i] == 2) continue;
            
            if (i > 0 && arr[i-1] == 2) {
                answer++;
                arr[i] = 1;
                arr[i-1] = 1;
            } else if (i < n-1 && arr[i+1] == 2) {
                answer++;
                arr[i] = 1;
                arr[i+1] = 1;
            } 
            
            
            
            // for (int k=0;k<max;k++) {
            //     System.out.print(arr[k] + ", ");
            // }
            // System.out.println();
        }
        
        
        return answer;
    }
}