

import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static int[][] arr;
	static String[] result;
	static String[] dx = new String[] {"D", "S", "L","R"};
	static Queue<String[]> que;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException{
    
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] first = bf.readLine().split(" ");
    	n = Integer.parseInt(first[0]);
    	arr = new int[n][2];
    	result = new String[n];

    	
    	for (int i = 0;i<n;i++) {
        	String[] line = bf.readLine().split(" ");
    		arr[i][0] = Integer.parseInt(line[0]);
    		arr[i][1] = Integer.parseInt(line[1]);
    	}
    	
    	for (int i=0;i<n;i++) {
    		String r = calculate(arr[i][0],arr[i][1]);
    		result[i] = r;
    	}
    	
    	
    	for (int i=0;i<n;i++) {
    		System.out.println(result[i]);
    	}
    	
    }
    
    static String calculate(int input, int output) {
    	visited = new boolean[10000];
    	String result = "";
    	
    	que = new LinkedList<>();
    	que.add(new String[] {Integer.toString(input), ""});
    	visited[input] = true;
    	
    	while (!que.isEmpty()) {
    		
    		String[] temp = que.poll();
        	int number = Integer.parseInt(temp[0]);
        	String mem = temp[1];
        	
        	
        	if (number == output) {
        		return mem;
        	}
    		
        	for (int i=0;i<4;i++) {
        		
        		if (dx[i].equals("D")) {
        			int transNum = D(number);
        			if (visited[transNum] == true) continue;
        			que.add(new String[]{Integer.toString(transNum), mem + "D"});
        			visited[transNum] = true;
        		} else if (dx[i].equals("S")) {
        			int transNum = S(number);
        			if (visited[transNum] == true) continue;
        			que.add(new String[]{Integer.toString(transNum), mem + "S"});
        			visited[transNum] = true;
        		} else if (dx[i].equals("L")) {
        			int transNum = L(number);
        			if (visited[transNum] == true) continue;
        			que.add(new String[]{Integer.toString(transNum), mem + "L"});
        			visited[transNum] = true;
        		} else {
        			int transNum = R(number);
        			if (visited[transNum] == true) continue;
        			que.add(new String[]{Integer.toString(transNum), mem + "R"});
        			visited[transNum] = true;
        		}
        		
        	}
        	
    	}
    	
    	System.out.println("result = " + result);

    	return result;
    }
    	
    
    
    static int D(int input) {
    	int result = 0;
    	
    	if (input*2 > 9999) {
    		result = (input*2) % 10000;	
    	} else {
    		result = input*2;
    	}
    	
    	return result;
    }

    static int S(int input) {
    	int result = 0;
    	
    	if (input==0) {
    		result = 9999;
    	} else {
    		result = input -1;
    	}
    	
    	return result;
    }
    
    static int L(int input) {
        return (input % 1000) * 10 + input / 1000;
    }

    static int R(int input) {
        return (input % 10) * 1000 + input / 10;
    }
    
    
}








