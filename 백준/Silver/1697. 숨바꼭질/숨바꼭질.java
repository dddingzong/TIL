
import java.util.*;

public class Main {
	
	static int N, K;
	static int[] dx = new int[] {1,-1,2};
	
    public static void main(String[] args) {
    	
    	Scanner input = new Scanner(System.in);
    	N = input.nextInt();
    	K = input.nextInt();
    	
    	System.out.print(bfs());
    	
    }
    
    static int bfs() {
    	boolean[] visited = new boolean[100001];
    	Queue<Integer> que = new LinkedList<>();
    	que.add(N);
    	visited[N] = true;
    	int result =0;
    	
    	while (!que.isEmpty()) {
    		int size = que.size();

            while (size-- > 0) {
                int cur = que.poll();

                if (cur == K) return result;

                for (int d : dx) {
                    int next;
                    if (d == 2) {
                        next = cur * 2;
                    } else {
                        next = cur + d;
                    }

                    if (next >= 0 && next <= 100000 && !visited[next]) {
                        visited[next] = true;
                        que.add(next);
                    }
                }
            }
            result++; 
    	}

    	
    	return result;
    }
}