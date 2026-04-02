

import java.util.*;
import java.io.*;

public class Main {
	
	static int n, w, l;
	static int[] arr;
	static int[] time;
	static Queue<Integer> que;
	
    public static void main(String[] args) throws IOException{
    
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] first = bf.readLine().split(" ");
    	n = Integer.parseInt(first[0]);
    	w = Integer.parseInt(first[1]);	
    	l = Integer.parseInt(first[2]);	
    	arr = new int[n];
    	time = new int[n];
    	que = new LinkedList<>();
    	
    	String[] line = bf.readLine().split(" ");
    	
    	for (int i = 0;i<n;i++) {
    		arr[i] = Integer.parseInt(line[i]);
    	}
    	  
    	int result =0;
    	int count = 0;
    	
    	que.add(arr[count]);
    	time[count] = w;
    	int cur = arr[count];
    	result++;
    	
    	while (!que.isEmpty()) {
    		result++;
        	
    		for (int i=0;i<n;i++) {
    			if (time[i] != 0) {
    				time[i]--;
    				if (time[i] == 0) {
    					cur -= que.poll();
    				}
    			}
  		
    		}
    	
    		if (count < n-1) {
	    		if (cur + arr[count +1] <= l) {
	    			count++;
	    			que.add(arr[count]);
	    			cur += arr[count];
	    			time[count] = w;
	    		}
    		}

    	}
    	
    	System.out.println(result);

    }
}








