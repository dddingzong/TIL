
	
	import java.io.*;
	import java.util.*;
	
	public class Main {
		
		static int n, e, v1, v2;
		static List<List<int[]>> graph;
		static int[] dist;
		static PriorityQueue<int[]> pq;
		static int[] route;
		static int start;
		
		public static void main(String[] args) throws IOException{
			
			// 변수 선언
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			
			String[] first = bf.readLine().split(" ");
			n = Integer.parseInt(first[0]);
			e = Integer.parseInt(first[1]);
			
			graph = new ArrayList<>();
			
			for (int i=0;i<n;i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i=0;i<e;i++) {
				 String[] line = bf.readLine().split(" ");
				 int startNode = Integer.parseInt(line[0])-1;
				 int endNode = Integer.parseInt(line[1])-1;
				 int weight = Integer.parseInt(line[2]);
				 
				 graph.get(startNode).add(new int[] {endNode,weight});
				 graph.get(endNode).add(new int[] {startNode,weight});
			}
			
	//		System.out.println();
	//		for (int i=0;i<n;i++) {
	//			List<int[]> tmp = graph.get(i);
	//			System.out.println("startnode = " + i);
	//			 for (int j=0;j<tmp.size();j++) {
	//				 System.out.println("end node = " + tmp.get(j)[0] + ", weight = " + tmp.get(j)[1]);
	//			 }
	//		}
			
			String[] last = bf.readLine().split(" ");
			v1 = Integer.parseInt(last[0]);
			v2 = Integer.parseInt(last[1]);
			
			// 변수 선언 끝
			
			Long answer1 = 0L;
			
			route = new int[]{v1,v2,n};
			start = 0;
			
			for (int i=0;i<route.length;i++) {
	//			System.out.print("start = " + start + ", endNode = " + route[i]); 
				int temp = func(route[i]-1);
				if (temp == Integer.MAX_VALUE) {
			        answer1 = Long.MAX_VALUE;
			        break;
			    }
				
	//			System.out.println(", temp = " + temp);
				answer1 += temp;
			}
			
			
			Long answer2 = 0L;
			route = new int[]{v2,v1,n};
			start = 0;
			
			for (int i=0;i<route.length;i++) {
	//			System.out.print("start = " + start + ", endNode = " + route[i]); 
				int temp = func(route[i]-1);
				if (temp == Integer.MAX_VALUE) {
			        answer2 = Long.MAX_VALUE;
			        break;
			    }
	//			System.out.println(", temp = " + temp);
				answer2 += temp;
			}

			long answer = Math.min(answer1, answer2);
			if (answer == Long.MAX_VALUE) {
			    System.out.println(-1);
			} else {
			    System.out.println(answer);
			}
		
		}

		
		static int func(int endNode) {
			int result =0;
			
			pq = new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
			dist = new int[n];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[start] = 0;
			
			pq.add(new int[] {start, 0});
			
			while(!pq.isEmpty()) {
				int[] tmp = pq.poll();
				int node = tmp[0];
				int sum = tmp[1];
				
				if (sum > dist[node]) continue;
				
				for (int i =0;i<graph.get(node).size();i++) {
					
					int[] nodeAndWeight = graph.get(node).get(i);
					
					int dest = nodeAndWeight[0];
					int destWeight = nodeAndWeight[1];
					
	//				System.out.println("dest = " + dest + ", weight = " + destWeight);
					
					if (dist[dest] <= sum + destWeight) continue;
					dist[dest] = sum + destWeight;
					
					pq.add(new int[] {dest, sum+destWeight});
				}
			}
			
			result = dist[endNode];
			start = endNode;
			
	//		for(int i=0;i<dist.length;i++) {
	//			System.out.print(dist[i] + ", ");
	//		}
	//		System.out.println();
			
			return result;
		}
	}
