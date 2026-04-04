

import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m, start, end;
	static List<List<int[]>> graph;
	static List<List<int[]>> reverseGraph;
	static int[] son;
	static int[] dist;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] first = bf.readLine().split(" ");
		
		n = Integer.parseInt(first[0]);
		
		String[] second = bf.readLine().split(" ");
		
		m = Integer.parseInt(second[0]);
		
		graph = new ArrayList<>();
		reverseGraph = new ArrayList<>();
		son = new int[n];
		dist = new int[n];
		
		for (int i=0;i<n;i++) {
			graph.add(new ArrayList<>());
			reverseGraph.add(new ArrayList<>());
		}
		
		
		for (int i=0;i<m;i++) {
			String[] line = bf.readLine().split(" ");
			int startNode = Integer.parseInt(line[0])-1;
			int endNode = Integer.parseInt(line[1])-1;
			int weight = Integer.parseInt(line[2]);
			graph.get(startNode).add(new int[] {endNode, weight});
			reverseGraph.get(endNode).add(new int[] {startNode, weight});
			son[endNode]++;
		}
		
//		for (int i=0;i<n;i++) {
//			List<int[]> tmp = graph.get(i);
//			System.out.println();
//			for (int j=0; j < tmp.size(); j++) {
//				System.out.print(tmp.get(j)[0] + ", " + tmp.get(j)[1] + "     ");
//			}
//		}
		
		String[] last = bf.readLine().split(" ");
		
		start = Integer.parseInt(last[0])-1;
		end = Integer.parseInt(last[1])-1;
		
		topology();
		countRoute();
	}
	
	static void topology() {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			List<int[]> injectList = graph.get(curr);
			
			for (int i=0;i<injectList.size();i++) {
				int[] next = injectList.get(i);
				int nextNode = next[0];
				int nextWeight = next[1];
				
				dist[nextNode] = Math.max(dist[nextNode], dist[curr] + nextWeight);
				son[nextNode]--;
				
				if (son[nextNode] == 0) {
					q.add(nextNode);
				}
				

			}

		}
		
		System.out.println(dist[end]);
		
	}
	
	static void countRoute() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n];
		int count = 0;
		
		q.add(end);
		visited[end] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			List<int[]> injectList = reverseGraph.get(curr);
			
			for (int i=0;i<injectList.size();i++) {
				int[] next = injectList.get(i);
				int beforeNode = next[0];
				int beforeWeight = next[1];
				
				if (dist[beforeNode] + beforeWeight == dist[curr]) {
					count++;
					
					if (!visited[beforeNode]) {
						visited[beforeNode] = true;
						q.add(beforeNode);
					}
				}

			}
			
			
			
		}
		
		System.out.print(count);
		
	}
	
}
