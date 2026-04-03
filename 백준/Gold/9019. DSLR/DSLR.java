

import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static int[][] arr;
	static String[] result;
	static Queue<Integer> que;
	static boolean[] visited;
	static int[] parent;
	static char[] command;
	
    public static void main(String[] args) throws IOException{
    
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	
    	n = Integer.parseInt(bf.readLine());
    	arr = new int[n][2];
    	result = new String[n];

    	for (int i = 0; i < n; i++) {
        	String[] line = bf.readLine().split(" ");
    		arr[i][0] = Integer.parseInt(line[0]);
    		arr[i][1] = Integer.parseInt(line[1]);
    	}
    	
    	for (int i = 0; i < n; i++) {
    		result[i] = calculate(arr[i][0], arr[i][1]);
    	}
    	
    	for (int i = 0; i < n; i++) {
    		System.out.println(result[i]);
    	}
    }
    
    static String calculate(int input, int output) {
    	visited = new boolean[10000];
    	parent = new int[10000];
    	command = new char[10000];
    	
    	que = new LinkedList<>();
    	que.add(input);
    	visited[input] = true;
    	
    	while (!que.isEmpty()) {
    		int number = que.poll();
        	
        	if (number == output) {
        		break;
        	}
    		
        	int d = D(number);
        	if (!visited[d]) {
        		visited[d] = true;
        		parent[d] = number;
        		command[d] = 'D';
        		que.add(d);
        	}
        	
        	int s = S(number);
        	if (!visited[s]) {
        		visited[s] = true;
        		parent[s] = number;
        		command[s] = 'S';
        		que.add(s);
        	}
        	
        	int l = L(number);
        	if (!visited[l]) {
        		visited[l] = true;
        		parent[l] = number;
        		command[l] = 'L';
        		que.add(l);
        	}
        	
        	int r = R(number);
        	if (!visited[r]) {
        		visited[r] = true;
        		parent[r] = number;
        		command[r] = 'R';
        		que.add(r);
        	}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	int cur = output;
    	
    	while (cur != input) {
    		sb.append(command[cur]);
    		cur = parent[cur];
    	}
    	
    	return sb.reverse().toString();
    }
    	
    static int D(int input) {
    	return (input * 2) % 10000;
    }

    static int S(int input) {
    	return (input == 0) ? 9999 : input - 1;
    }
    
    static int L(int input) {
        return (input % 1000) * 10 + input / 1000;
    }

    static int R(int input) {
        return (input % 10) * 1000 + input / 10;
    }
}