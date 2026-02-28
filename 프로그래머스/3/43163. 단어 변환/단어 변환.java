import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int length = words.length;
        boolean[] visits = new boolean[length];
        Queue<String[]> que = new LinkedList<>();
        
        que.add(new String[]{begin,"0"});
        
        while (!que.isEmpty()) {
            
            String[] wordAndCount = que.poll();
            String word = wordAndCount[0];
            int count = Integer.parseInt(wordAndCount[1]);

            if (word.equals(target)) return count;
            
            for (int j=0;j<length;j++) {
                int diff = 0;
                
                String[] splitedWord = word.split("");
                String[] splitedWords = words[j].split("");
                
                for (int a =0; a < splitedWord.length; a++) {
                    if (!splitedWord[a].equals(splitedWords[a])) diff++;
                }
            
                
                if (visits[j] == false && diff == 1) {
                    visits[j] = true;
                    que.add(new String[]{words[j],String.valueOf(count+1)});
                }
            }

        }
        
        return answer;
    }
}