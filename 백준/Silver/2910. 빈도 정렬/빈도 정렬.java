
import java.util.*;

public class Main {
    public static void main(String[] args) {
       
    	Scanner input = new Scanner(System.in);

    	int N = input.nextInt();
    	int C = input.nextInt();
    	int[] arr = new int[N];
    	
    	for (int i =0; i< N; i++) {
    		arr[i] = input.nextInt();
    	}
    	
    	Map<Integer, Integer> countMap = new HashMap<>();
    	Map<Integer, Integer> indexMap = new HashMap<>();
    	
    	for (int i =0; i< N; i++) {
    		countMap.put(arr[i], countMap.getOrDefault(arr[i],0)+1);
    		
    		if (!indexMap.containsKey(arr[i])) {
    			indexMap.put(arr[i], i);
    		}
    	}
    	List<Integer> keys = new ArrayList<>(countMap.keySet());
    	
    	keys.sort((a,b) -> {
    		if (!countMap.get(a).equals(countMap.get(b))) {
    			return countMap.get(b) - countMap.get(a);
    		}
    		return indexMap.get(a) - indexMap.get(b);
    	});
    	
    	
    	for (Integer key: keys) {
    		String repeat = (key + " ").repeat(countMap.get(key));
    		System.out.print(repeat);
    	}
    	
    	
    }
}