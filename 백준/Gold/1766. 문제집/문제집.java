

import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static List<List<Integer>> arr;
	static List<Integer> answer;
	static int[] son;
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] first = bf.readLine().split(" ");
		
		n = Integer.parseInt(first[0]);
		m = Integer.parseInt(first[1]);
		
		answer = new ArrayList<>();
		arr = new ArrayList<>();
		son = new int[n];
		
		for (int i=0;i<n;i++) {
			arr.add(new ArrayList<>());
		}
		
		
		for (int i=0;i<m;i++) {
			String[] line = bf.readLine().split(" ");
			int priNode = Integer.parseInt(line[0])-1;
			int postNode = Integer.parseInt(line[1])-1;
			arr.get(priNode).add(postNode);
			son[postNode]++;
		}
		
		for (int i=0;i<n;i++) {
			Collections.sort(arr.get(i),(a,b) -> a-b);
		}
		
		pq = new PriorityQueue<Integer>((a,b) -> a-b);
		
		for (int i=0;i<n;i++) {
			if (son[i] == 0) {
				pq.add(i);
			}
		}
		
		while (!pq.isEmpty()) {
			int num = pq.poll();
			
			if (arr.get(num).isEmpty()) {
				answer.add(num);
			} else {
				List<Integer> list = arr.get(num);
				for (int i=0;i<list.size();i++) {
					int number = list.get(i);
					son[number]--;
					
					if (son[number] == 0) {
						pq.add(number);
					}
				}
				answer.add(num);
				
			}
			
			
		}
		
		for (int i=0;i<n;i++) {
			System.out.print(answer.get(i)+1 + " ");
		}

	}
}
