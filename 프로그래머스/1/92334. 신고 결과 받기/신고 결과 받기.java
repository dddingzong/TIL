import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        List<Integer> answerList = new ArrayList<>();
        
        // 신고자 : 신고 당한 사람
        Map<String, Set<String>> reportMap = new HashMap<>();
        // 신고 당한 사람 : 횟수
        Map<String, Integer> countMap = new HashMap<>();
        
        Map<String, Integer> answerMap = new HashMap<>();
        
        for (String id : id_list) {
            reportMap.put(id, new HashSet<>());
            countMap.put(id,0);
        }
        
        for (int i=0;i<report.length;i++) {
            String[] reportArr = report[i].split(" ");
            String reporter = reportArr[0];
            String reported = reportArr[1];
            
            Set<String> reportSet = reportMap.get(reporter);
            int duplicateCheck = reportSet.size();
            
            reportSet.add(reported);
            reportMap.put(reporter, reportSet);
            
            if (duplicateCheck != reportSet.size()) {
                countMap.put(reported, countMap.get(reported) + 1);
            }
        }
        
        // 횟수 계산
        // 신고 한 사람중에서 최종 신고자의 인원 수
        // + 자신의 신고 여부
        
        // 신고 당한 사람 Set 만들기
        Set<String> reportedSet = new HashSet<>();
        
        for (Map.Entry<String, Integer> entry : countMap.entrySet() ) {
            if (entry.getValue() >= k) {
                   reportedSet.add(entry.getKey());
            }
        }
        
        for (Map.Entry<String, Set<String>> entry : reportMap.entrySet()) {       
            int cnt = 0;
            String member = entry.getKey();
            Set<String> set = entry.getValue();
            
            // System.out.print("member = " + member + ": ");
            
            for (String mem : set) {
                // System.out.print("mem = " + mem + " ");
                if (reportedSet.contains(mem)) cnt++;
            }
            
            // System.out.println();
            
            answerMap.put(member, cnt);
            answerList.add(cnt);
        }
        
        for (int i=0;i<id_list.length;i++) {
            answer[i] = answerMap.get(id_list[i]);
        }
        
        return answer;
    }
}