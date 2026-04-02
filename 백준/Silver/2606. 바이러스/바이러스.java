
import java.io.*;
import java.util.*;


public class Main {
	
	static int n;
	static List<List<Integer>> list;
	static int cnt = 0;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException{
    	Scanner sc = new Scanner(System.in);
    	
    	int k = sc.nextInt();
    	int n = sc.nextInt();
    	
    	list = new ArrayList<>();
    	visited = new boolean[k];
    	
    	for (int i=0;i<k;i++) {
    		list.add(new ArrayList<>());
    	}
    	
    	cnt = 0;
    	
    	for (int i=0;i<n;i++) {
    		int number = sc.nextInt();
    		int oppositenNumber = sc.nextInt();
    		list.get(number-1).add(oppositenNumber);
    		list.get(oppositenNumber-1).add(number);
    	}
    	
    	visited[0] = true;
    	int result = dfs(1);
    	
    	System.out.print(result);
    	
    	
    	
    }
    
    
    static int dfs(int start) {
    	
    	for (int i=0;i < list.get(start-1).size() ;i++) {
    		int number = list.get(start-1).get(i);
    		
        	if (visited[number-1] == false) {
        		visited[number-1] = true;
        		cnt++;
        		dfs(number);
        	}
    		
    	}
    	
    	return cnt;
    }
    
    
}