class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = 200000000;
        int mid = (left + right) / 2;
        
        // 이진탐색으로 가운데 값 찾기
        
        while (left <= right) {
            // 건너는 식 계산
            mid = (left + right) / 2;
            
            if (simulate(stones, mid, k)) { // cnt <= k -> mid를 키워야한다
                left = mid + 1;
                answer = mid;
                
            } else { // k > cnt -> mid를 줄여야한다
                right = mid -1;
            }

        }

        return answer; 
    }
    
    static boolean simulate (int[] stones, int mid, int k){
        int cnt =0;
        for (int i=0;i<stones.length;i++) {
            if (stones[i] >= mid) {
                cnt = 0;
            } else {
                cnt++;
                if (cnt >= k) {
                    return false;
                }
            }
        }
        
        
        
        
        
        return true;
    }
}