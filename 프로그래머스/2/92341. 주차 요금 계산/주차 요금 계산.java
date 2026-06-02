import java.util.*;


class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        int basicT = fees[0];
        int basicF = fees[1];
        int circleM = fees[2];
        int circleC = fees[3];
        
        // 차량번호, 요금
        Map<String, Integer> cost = new TreeMap<>();
        
        // 차량번호, 입차시간
        Map<String, List<String>> in = new TreeMap<>();
        
        // 차량번호, 출차시간
        Map<String, List<String>> out = new TreeMap<>();
        
        
        for (int i=0;i<records.length;i++) {
            String[] cur = records[i].split(" ");
            
            String time = cur[0];
            String number = cur[1];
            String type = cur[2];
            
            if (type.equals("IN")) {
                if (!in.containsKey(number)) {
                    in.put(number,new ArrayList<>());
                }
                in.get(number).add(time);
                
            } else {
                if (!out.containsKey(number)) {
                    out.put(number,new ArrayList<>());
                }
                out.get(number).add(time);
            }
        }
        
        // in이랑 out이랑 하나씩 꺼내면서 진행
        
        for (Map.Entry<String, List<String>> entry : in.entrySet()) {
            
            String number = entry.getKey();
            List<String> inTimeList = entry.getValue();
            
            int totalTime = 0;
                
            for (int i=0;i<inTimeList.size();i++) {
                String[] inTime = inTimeList.get(i).split(":");

                int inHour = Integer.parseInt(inTime[0]);
                int inMinute = Integer.parseInt(inTime[1]);

                int outHour = 0;
                int outMinute = 0;

                if (!out.containsKey(number) 
                    || out.get(number).size() <= i) { // 출차가 없는 경우

                    outHour = 23;
                    outMinute = 59;

                } else { // 출차가 있는 경우
                    List<String> outTimeList = out.get(number);
                    String[] OutTime = outTimeList.get(i).split(":");

                    outHour = Integer.parseInt(OutTime[0]);
                    outMinute = Integer.parseInt(OutTime[1]);

                }

                // 시간 계산 이후 map에 넣기

                int timeDiff = (outHour*60 + outMinute) - (inHour*60 + inMinute);
                totalTime += timeDiff;
            }
            
            int totalFee = 0;

            if (totalTime <= basicT) { // 기본요금
                totalFee = basicF;
            } else { // 초과요금
                int tmp = (totalTime - basicT) / circleM;

                if ((totalTime - basicT) % circleM == 0) {
                    totalFee = basicF + tmp * circleC;
                } else {
                    totalFee = basicF + (tmp + 1) * circleC;
                }
            }
            
            cost.put(number,totalFee); 
        }
        
        
        int[] answer = new int[cost.size()];
        int cnt = 0;
        
        for (Map.Entry<String, Integer> entry : cost.entrySet()) {
            
            
            int c = entry.getValue();
            
            answer[cnt] = c;
            cnt++;
        }
        
        return answer;
    }
}