import java.util.HashMap;
import java.util.Map;

public class galois {
	
    public static void main(String[] args) {
        
        int a[][]=new int[8][8];
        int b[][]=new int[8][8];
        int c[] = new int[3];
        
        int x = 2;
        int y = 4;
        int res=0;
        
        int z[]={0,1,x,x^1,y,y^1,x^y,x^y^1};
 
         Map<Integer,String> map=new HashMap<Integer,String>();  
          map.put(0,"000");  
          map.put(1,"001");  
          map.put(2,"010");  
          map.put(3,"011");  
          map.put(4,"100");  
          map.put(5,"101");  
          map.put(6,"110");  
          map.put(7,"111");  
//    
         
         for(int i=0;i<8;i++){
             for(int j=0;j<8;j++){
                 a[i][j]= z[i] ^ z[j];
             }
         }
       
         
         for(int i=0;i<8;i++){
        	 for(int j=0;j<8;j++){
        		 int l=j;
        		 //System.out.println("i: "+i+" j: "+j);
        		 c[0]=l & 0x07;
        		 for(int k=0;k<2;k++){
        			 //System.out.println("l:"+l);
        			 int msb = l & 0x04;
        			 //System.out.println("msb:"+msb);
        			 if(msb == 4){
        				 l=l<<1;
        				 l=l^3;
        				 l=l & 0x07;
        			 }
        			 else{
        				 l=l<<1;
        				 l=l & 0x07;
        			 }
        			 c[k+1]=l;
        		 } 
        			 int dig = i & 0x01;
        			 int dig1 = i & 0x02;
        			 int dig2 = i & 0x04;
        			 //System.out.println("dig, dig1, dig2: "+dig+" "+dig1+" "+dig2);
        			 //System.out.println("c[0], c[1], c[2]: "+c[0]+" "+c[1]+" "+c[2]);
        			 if(dig == 1 && dig1 == 2 && dig2 == 0){
        				 res=c[0] ^ c[1];
        			 }
        			 else if(dig == 1 && dig2 == 4 && dig1 == 0){
        				 res=c[0] ^ c[2];
        			 }
        			 else if(dig1 == 2 && dig2 == 4 && dig == 0){
        				 res=c[1] ^ c[2];
        			 }
        			 else if(dig == 1 && dig1 == 2 && dig2 == 4){
        				 res=c[0] ^ c[1] ^ c[2];
        			 }
        			 else if(dig == 1 && dig1 == 0 && dig2 == 0){
        				 res=c[0];
        			 }
        			 else if(dig == 0 && dig1 == 2 && dig2 == 0){
        				 res=c[1];
        			 }
        			 else if(dig == 0 && dig1 == 0 && dig2 == 4){
        				 res=c[2];
        			 }
        			 //System.out.println("res: "+res);
        			 b[i][j]=res;
        	 }
        	 
        	 //System.out.println();
         }
         
         
         System.out.println("Addition Galois Field: ");
         for(int i=0;i<8;i++){
             for(int j=0;j<8;j++){
                 System.out.print(map.get((a[i][j])));
                 System.out.print("\t");
             }
             System.out.println();
         }
         
         System.out.println("Multiplication Galois Field: ");
         for(int i=0;i<8;i++){
             for(int j=0;j<8;j++){
                 System.out.print(map.get((b[i][j])));
                 System.out.print("\t");
             }
             System.out.println();
         }
     
        
    }

}
