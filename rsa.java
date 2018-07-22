import java.util.Scanner;

public class rsa {
	
	static int phi(int p,int q){
		int phin = (p-1) * (q-1);
		return phin;
	}
	
	static int gcd(int r1,int r2){
		int q,r,t1=0,t2=1,t,rem,mi;
		rem=r1;
		while(r2!=0){
			q = (int)r1/r2;
			r=r1%r2;
			r1=r2;
			r2=r;
			t=t1-q*t2;
			t1=t2;
			t2=t;
		}
		if(r1==1){
			if(t1<0){
				mi=rem+t1;
			}
			else{
				mi=t1;
			}
			
		}else{
			mi=0;
		}
		return mi;
	}
	
	static public int getSquareAndMultipy(int exponent, int baseElement, int modulus) {
		byte[] expBinaryArray=Integer.toBinaryString(exponent).getBytes();
		int result=baseElement;
		for(int i=1;i<expBinaryArray.length;++i) {
		result=(result*result)%modulus;
		if(expBinaryArray[i]=='1') {
		result=(result*baseElement)%modulus;
		}
		}
		return result;
		}

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter p:");
		int p= sc.nextInt();
		System.out.println("Enter q: ");
		int q= sc.nextInt();
		System.out.println("Enter e: ");
		int e= sc.nextInt();
		System.out.println("Enter message: ");
		int m= sc.nextInt();
		
		int phi=phi(p,q);
		int n=p*q;
		int d= gcd(phi, e) % phi;
		
		int c= getSquareAndMultipy(e, m, n);
		
		int res= getSquareAndMultipy(d, c, n);
		
		
		System.out.println("Cipher: "+c+", Original Message: "+res);
		
		
	}
}


/*
OUTPUT :-

Enter p:
11
Enter q: 
7
Enter e: 
13
Enter message: 
25
Cipher: 60, Original Message: 25
*/
