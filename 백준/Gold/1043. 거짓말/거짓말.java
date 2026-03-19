
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	
    	int N =input.nextInt();
    	int M =input.nextInt();
 
    	int C =input.nextInt();
    	
    	Set<Integer> known = new HashSet<>();
    	
    	
    	for (int i=0;i<C;i++) {
    		known.add(input.nextInt());
    	}
    	
    	int[][] party = new int[M][];

    	for (int i=0;i<M;i++) {
        	int partyCount =input.nextInt();
        	party[i] = new int[partyCount];  
        	for (int j=0;j<partyCount;j++) {
        		party[i][j] = input.nextInt();
        	}   	
    	}
    	
    	int result = 0;
    	boolean[] knownGruop = new boolean[M];
    	
    	// known 갱신 
    	boolean change = true;
    	while (change == true) {
    		change = false;
	    	for (int i=0;i<M;i++) {
	    		if (knownGruop[i] == false) {
		    		int[] cycle = party[i];
		    		
		    		for (int j=0;j<cycle.length;j++) {
		    			if (known.contains(cycle[j])) {
		    				knownGruop[i] = true;
		    				change = true;
		    				break;
		    			}
		    		}
	    		}
	    		
	    	}
	    	
	    	for (int i =0;i<M;i++) {
	    		if (knownGruop[i]) {
	    			for (int p : party[i]) known.add(p);
	    		}
	    	}
    	}
    	
    	for (int i=0;i<M;i++) {
    		if (knownGruop[i] == false) result++;
    	}
    	
    	System.out.print(result);
    }
}