import java.util.*;
class HammingCode
{ 
	static void print(int ar[]) 						// print elements of array 
	{ 
		for (int i = 1; i < ar.length; i++) { 
			System.out.print(ar[i]); 
		} 
		System.out.println(); 
	} 

	static int[] calculation(int[] ar, int r) 			// calculating value of redundant bits 
	{ 
		for (int i = 0; i < r; i++) 
		{ 
			int x = (int)Math.pow(2, i); 
			for (int j = 1; j < ar.length; j++) 
			{ 
				if (((j >> i) & 1) == 1) 
				{ 
					if (x != j) 
						ar[x] = ar[x] ^ ar[j]; 
				} 
			} 
			System.out.println("r" + x + " = "+ ar[x]); 
		} 
		return ar; 
	} 

	static int[] generateCode(String str, int M, int r) 
	{ 
		int[] ar = new int[r + M + 1]; 
		int j = 0; 
		for (int i = 1; i < ar.length; i++) 
		{ 
			if ((Math.ceil(Math.log(i) / Math.log(2)) - Math.floor(Math.log(i) / Math.log(2))) == 0) 						// if i == 2^n for n in (0, 1, 2, .....) 
			{ 																												// then ar[i]=0 
				ar[i] = 0; 																									// codeword[i] = 0 ---- 
			} 																												// redundant bits are intialized with value 0 
			else 
			{ 
				ar[i] = (int)(str.charAt(j) - '0'); 																		// codeword[i] = dataword[j] 
				j++; 
			} 
		} 
		return ar; 
	} 

	public static void main(String[] args) 
	{ 
        System.out.println("Enter Data "); 
        Scanner sc=new Scanner(System.in);        
        String str=sc.next(); 
		int M = str.length(); 
		int r = 1; 
		while (Math.pow(2, r) < (M + r + 1)) 
		{ 
			r++; 																// r is number of redundant bits 
		} 
		int[] ar = generateCode(str, M, r); 
		System.out.println("Generated hamming code "); 
		ar = calculation(ar, r); 
		print(ar); 
	} 
} 
