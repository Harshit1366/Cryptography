import java.util.Scanner;

public class aes {
    
    public static void main(String[] args) {
        
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter 16-bit plain text: ");
        String plain= sc.next();
        System.out.println("Enter 16-bit key: ");
        String key= sc.next();
        char res[]=new char[4];
        char sub[]=new char[4];
        
        char subbytes[][]= {
                {'9','4','A','B'},
                {'D','1','8','5'},
                {'6','2','0','3'},
                {'C','E','F','7'}
        };
        
        int count=0;
        int text[]=new int[16];
        int ans[]=new int[16];
        for(int i=0;i<4;i++){
               int a=(int) plain.charAt(count);
               int b=(int) plain.charAt(count+1);
               int c=(int) plain.charAt(count+2);
               int d=(int) plain.charAt(count+3);
               int e=a*8+b*4+c*2+d;
               res[i]=(char) e;
                count+=4;
            }
        count=0;
        for(int i=0;i<2;i++){
             int a=(int) plain.charAt(count)-48;
             int b=(int) plain.charAt(count+1)-48;
             int c=(int) plain.charAt(count+2)-48;
             int d=(int) plain.charAt(count+3)-48;
             //System.out.println(a+" "+b+" "+c+" "+d);
             int e=a*2+b;
             int f=c*2+d;
             //System.out.println(count);
             //System.out.println(e+" "+f);
            sub[i]= subbytes[e][f];
            count+=8;
        }
        count=4;
        for(int i=2;i<4;i++){
             int a=(int) plain.charAt(count)-48;
             int b=(int) plain.charAt(count+1)-48;
             int c=(int) plain.charAt(count+2)-48;
             int d=(int) plain.charAt(count+3)-48;
             int e=a*2+b;
             int f=c*2+d;
             //System.out.println(a+" "+b+" "+c+" "+d);
             //System.out.println(count);
             //System.out.println(e+" "+f);
            sub[i]= subbytes[e][f];
            count+=8;
        }
        //for(int i=0;i<4;i++) System.out.println(sub[i]);
        
        char temp=sub[2];
        sub[2]=sub[3];
        sub[3]=temp;
        
        int decimal = 0;
        count=0;
        StringBuilder bin = new StringBuilder();
        
        for(int i=0;i<4;i++){
        decimal = Integer.parseInt(String.valueOf(sub[i]), 16);
        //System.out.println("dec: "+decimal);
        //String binary = Integer.toBinaryString(decimal);
        //System.out.println(binary);
        for(int j=0;j<4;j++){
        	int div= decimal % 2;
        	decimal=(int)decimal/2;
            bin.append((char)div);
        }
        bin.reverse();
        bin.toString();
        for(int j=0;j<4;j++){
        text[count]=(int)bin.charAt(j);
        //System.out.println("text:"+text[count]);
        count++;
        }
        }
    
        
        for(int i=0;i<16;i++){
            ans[i]= text[i] ^ (int)key.charAt(i)-48;
        }
        
        System.out.println("Encrypted text: ");
        for(int i=0;i<16;i++) System.out.print(ans[i]);
        
        sc.close();
        
    }

}

/*
OUTPUT:-
Enter 16-bit plain text: 
1000011110010110
Enter 16-bit key: 
0101101001011010
Encrypted text: 
0011100011011111
*/