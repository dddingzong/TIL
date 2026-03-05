
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	
    	int N = input.nextInt();
    	int M = input.nextInt();
    	

    	List<List<int[]>> buses = new ArrayList<>();
    	for (int i=0;i<=N;i++) {
    		buses.add(new ArrayList<>());
    	}
    	
    	for(int i=0;i<M;i++) {
    		buses.get(input.nextInt()).add(new int[]{input.nextInt(),input.nextInt()});
    	}
    	
    	
    	int departure = input.nextInt();
    	int arrival = input.nextInt();
    	
    	int[] dist = new int[N+1];
    	Arrays.fill(dist, Integer.MAX_VALUE);
    	dist[departure] = 0;
    
    	PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
    	
    	pq.add(new int[]{0,departure});
    	
    	while(!pq.isEmpty()) {
    		int[] current = pq.poll();
    		int cost = current[0];
    		int node = current[1];
    		
    		if (cost > dist[node]) continue;
    		
    		for (int[] next : buses.get(node)) {
    			int nextNode = next[0];
    			int nextCost = next[1];
    			
    			
    			if (dist[node] + nextCost < dist[nextNode]) {
    				dist[nextNode] = dist[node] + nextCost;
    				pq.add(new int[] {dist[nextNode], nextNode});
    			}
    			
    		}

    	}
    	
    	System.out.println(dist[arrival]);
    	
    	
    	
    }
    
    
    
}