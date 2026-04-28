class Solution {
    public String solution(String new_id) {
        String answer = "";
        String[] arr = toArr(new_id);
        
        // step 1 
        for (int i=0;i<arr.length;i++) {
            if (arr[i].compareTo("A") >= 0 && arr[i].compareTo("Z") <= 0) {
                arr[i] = arr[i].toLowerCase();
            }
        }
        
        arr = printCommend("1", arr);
        
        // step 2
        for (int i=0;i<arr.length;i++) {
            if ((arr[i].compareTo("a") >= 0 && arr[i].compareTo("z") <= 0)
                || (arr[i].compareTo("0") >= 0 && arr[i].compareTo("9") <= 0)
                || arr[i].equals("-")
                || arr[i].equals("_")
                || arr[i].equals(".")
               ) {
                continue;
            } else {
                arr[i] = null;
            }
        }
        
        arr = printCommend("2", arr);
        
        // step 3
        String tmp = "";
        boolean flag = true;
        for (int i=0;i<arr.length;i++) {
            if (!arr[i].equals(".")) {
                flag = true;
                tmp += arr[i];
            } else {
                if (flag == false) continue;
                tmp += arr[i];
                flag = false;
            }
        }
        
        System.out.println("step 3 = " + tmp);
        
        // step 4
        if (tmp.substring(0,1).equals(".")) {
            tmp = tmp.substring(1,tmp.split("").length);
        }
        
        arr = tmp.split("");
        if (arr[arr.length-1].equals(".")) {
            tmp = tmp.substring(0,arr.length-1);
        }
        
        System.out.println("step 4 = " + tmp);
        
        //step 5
        if (tmp.length() == 0) tmp = "a";
        
        System.out.println("step 5 = " + tmp);
        
        // step 6
        if (tmp.split("").length >= 16) {
            tmp = tmp.substring(0,15);
        }
        
        arr = tmp.split("");
        if (arr[arr.length-1].equals(".")) {
            tmp = tmp.substring(0,arr.length-1);
        }
        
        System.out.println("step 6 = " + tmp);
        
        arr = tmp.split("");
        while (tmp.length() <= 2) {
            tmp += arr[arr.length-1];
        }
        
        answer = tmp;
        
        return answer;
    }
    
    static String toString(String[] arr){
        String result = "";
        for (int i=0;i<arr.length;i++) {
            if (arr[i] == null) continue;
            result += arr[i];
        }
        return result;
    }
    
    static String[] toArr(String str){
        return str.split("");
    }
    
    static String[] printCommend(String number, String[] arr){
        String tmpAnswer = toString(arr);
        String[] tmpArr = toArr(tmpAnswer);
        System.out.println("step " + number + " = " + tmpAnswer);
        return tmpArr;
    }
}