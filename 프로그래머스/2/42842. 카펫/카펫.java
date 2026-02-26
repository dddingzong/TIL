class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = (brown+4)/2;
        int total = brown + yellow;
        int x=0;
        int y=0;
        
        for (x=sum-1, y=1; x >= y; x--, y++) {
            if (x*y==total) {
                answer = new int[]{x,y};
                break;
            }
        }
        
        return answer;
    }
}