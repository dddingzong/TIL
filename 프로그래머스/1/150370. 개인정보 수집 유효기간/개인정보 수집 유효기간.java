import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        int year = Integer.parseInt(today.substring(0,4));
        int month = Integer.parseInt(today.substring(5,7));
        int day = Integer.parseInt(today.substring(8,10));
        // System.out.print(year + " " + month + " " + day);
        
        Map<String, Integer> termMap = new HashMap<>();
        
  
        for (String term : terms) {
            String[] termArr = term.split(" ");
            termMap.put(termArr[0], Integer.parseInt(termArr[1]));
        }
        
        // 하나씩 돌면서 확인하기
        for (int i=0;i<privacies.length;i++) {
            String[] dateAndTerm = privacies[i].split(" ");
            String date = dateAndTerm[0];
            String term = dateAndTerm[1];
            
            int t = termMap.get(term);
            
            int priyear = Integer.parseInt(date.substring(0,4));
            int primonth = Integer.parseInt(date.substring(5,7));
            int priday = Integer.parseInt(date.substring(8,10));
            
            int calMonth = year*12 + month;
            int calPirMonth = priyear*12 + primonth;
            int monthdiff = calMonth - calPirMonth;
            
            if (day >= priday) monthdiff++;
            
            if (monthdiff > t) answerList.add(i+1);
        }
        
        int[] answer = new int[answerList.size()];
        for (int i=0;i<answerList.size();i++) {
            answer[i] = answerList.get(i);
        }
        
        
        
        return answer;
    }
}