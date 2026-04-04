

import java.io.*;
import java.util.*;

public class Main {
	
	static int v, e, k;
	static List<List<int[]>> graph;
	static PriorityQueue<int[]> que;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] first = bf.readLine().split(" ");
		v = Integer.parseInt(first[0]);
		e = Integer.parseInt(first[1]);
		
		
		String[] second = bf.readLine().split(" ");
		k = Integer.parseInt(second[0])-1;
		
		graph = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < e; i++) {
			String[] line = bf.readLine().split(" ");
			int startNode = Integer.parseInt(line[0]) - 1;
			int endNode = Integer.parseInt(line[1]) - 1;
			int weight = Integer.parseInt(line[2]);
			
			graph.get(startNode).add(new int[] {endNode, weight});
		}
		
		
		dijkstra();
		
		for (int i = 0; i < v; i++) {
			if (dist[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}
	

	static void dijkstra() {	
		dist = new int[v];
		Arrays.fill(dist, INF);
		dist[k] = 0; 
		
		que = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		que.add(new int[] {k, 0});

		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			int number = tmp[0];
			int sum = tmp[1];
			
			if (sum > dist[number]) continue;
			
			for (int[] nextInfo : graph.get(number)) {
				int next = nextInfo[0];
				int weight = nextInfo[1];
				int nextCost = sum + weight;
				
				if (dist[next] > nextCost) {
					dist[next] = nextCost;
					que.add(new int[] {next, nextCost});
				}
			}
			
		}
	
	}
}
