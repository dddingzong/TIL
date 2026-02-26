
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int[] arr = new int[21];
        for(int i = 1; i < 21; i++) {
        	arr[i] = i;
        }
        
        
        
        for(int i = 0; i < 10; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int mid = (a+b)/2;
            
            for (int j = a, k = b; j<=mid; j++, k--) {
            	int temp = arr[j];
            	arr[j] = arr[k];
            	arr[k] = temp;
            }
        }
        
        
        for(int i = 1; i < 21; i++) {
        	System.out.print(arr[i] + " ");
        }
    }
}