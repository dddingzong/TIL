class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        // yellow = (x-2)*(y-2)
        // yellow = xy -2(x+y) +4
        // yellow = xy -2(brown/2+2) + 4
        // yellow = xy -brown
        // yellow + brown = xy
        
        // brown/2 + 2 = x+y
        
        int sum = brown/2 + 2;
        int mul = brown + yellow;
        
        int x=0;
        int y=0;
        for (int i=3;i<sum;i++){
            y = i;
            x = sum-i;
            
            if (x+y == sum && x*y == mul) {
                break;
            }
            
        } 
        answer = new int[]{x,y};

        
        
        
        
        return answer;
    }
}