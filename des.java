import java.util.Random;
public class des {
	
    static int[] left(int[] array){
    	int temp=array[0];
    	for(int i=0;i<27;i++){
    		array[i]=array[i+1];
    	}
    	array[27]=temp;
    	return array;
    }
	
	public static void main(String[] args) {
		
		int parity[] = {
				57, 49, 41, 33, 25, 17, 9, 1,
				58, 50, 42, 34, 26, 18, 10, 2,
				59, 51, 43, 35, 27, 19, 11, 3,
				60, 52, 44, 36, 63, 55, 47, 39,
				31, 23, 15, 7, 62, 54, 46, 38,
				30, 22, 14, 6, 61, 53, 45, 37,
				29, 21, 13, 5, 28, 20, 12, 4
	};
		
		int compress[] = {
		14, 17, 11, 24, 1, 5, 3, 28,
		15, 6, 21, 10, 23, 19, 12, 4,
		26, 8, 16, 7, 27, 20, 13, 2,
		41, 52, 31, 37, 47, 55, 30, 40,
		51, 45, 33, 48, 44, 49, 39, 56,
		34, 53, 46, 42, 50, 36, 29, 32
		};
		
		int key[]= new int[64];
		int drop[] = new int[56];
		int arr1[] = new int[28];
		int arr2[] = new int[28];
		int shifted_arr[] = new int[56];
		int res[] = new int[48];
		
		for(int i=0;i<64;i++){
			key[i] = new Random().nextInt(2);
		}
		
		System.out.println("Input 64-bit Key: ");
		for(int i=0;i<64;i++){
			System.out.print(key[i]);
		}
		
		for(int i=0;i<56;i++){
			drop[i] = key[parity[i]-1];
		}
		
		System.out.println("\n56-bit key after parity drop: ");
		for(int i=0;i<56;i++){
			System.out.print(drop[i]);
		}
		
		for(int i=0;i<28;i++){
			arr1[i]=drop[i];
		}
		
		for(int i=0;i<28;i++){
			arr2[i]=drop[i+28];
		}
		
		left(arr1);
		left(arr2);
		
		for(int i=0;i<28;i++){
			shifted_arr[i] = arr1[i]; 
		}
		
		for(int i=0;i<28;i++){
			shifted_arr[i+28] = arr2[i]; 
		}
		
		System.out.println("\nShifted Array: ");
		for(int i=0;i<56;i++){
			System.out.print(shifted_arr[i]);
		}
		
		for(int i=0;i<48;i++){
			res[i]=  shifted_arr[compress[i]-1];
		}
		
		System.out.println("\n48-bit key output: ");
		
		for(int i=0;i<48;i++){
			System.out.print(res[i]);
		}
		
	}
}

/*
OUTPUT :-

Input 64-bit Key: 
0101111011110011001110010001010100000110000110110000010010010010
56-bit key after parity drop: 
10000010000000110000011010101011001101011001001001011111
Shifted Array: 
00000100000001100000110101010110011010110010010010111111
48-bit key output: 
100100011110000010000000011101111000011111100000
	
*/