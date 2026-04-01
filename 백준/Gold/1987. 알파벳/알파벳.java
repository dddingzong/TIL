
import java.io.*;
import java.util.*;


public class Main {
	
	static int R;
	static int C;
    static char[][] board;
    static int answer = 0;
	static int[] dx = new int[] {1,0,-1,0};
	static int[] dy = new int[] {0,1,0,-1};
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
    	
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        
        Set<Character> set = new HashSet<>();
        set.add(board[0][0]);

        dfs(0, 0, set, 1);

        System.out.println(answer);
    	
    }
    
    static void dfs(int x, int y, Set<Character> set, int depth) {
        answer = Math.max(answer, depth);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

            char next = board[nx][ny];

            if (set.contains(next)) continue;

            set.add(next);              
            dfs(nx, ny, set, depth + 1); 
            set.remove(next); 
        }
    }
    
    
}