class Solution {
    
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    static void dfs(int[] numbers, int target, int sum, int index) {
        
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        dfs(numbers, target, sum+numbers[index], index+1);
        dfs(numbers, target, sum-numbers[index], index+1);
    }
    
}