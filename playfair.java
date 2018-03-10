package mine;

import java.util.Scanner;

public class play {

	public static void main(String[] args) {

		char play[][] = new char[5][5];
		char bingo[] = new char[25];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter key: ");
		String key = sc.next();
		System.out.println("Enter plain text: ");
		String p = sc.next();

		int l = 0;
		int count[] = new int[26];

		for (int i = 0; i < key.length(); i++) {
			count[(int) (key.charAt(i)) - 97]++;
			if (count[(int) (key.charAt(i)) - 97] == 1) {
				bingo[l] = key.charAt(i);
				l++;
			}
		}

		// for(int j=0;j<26;j++){
		// System.out.println("count["+j+"]="+count[j]+"\n");
		// }

		int e = 0;

		for (int i = 0; i < 26; i++) {
			if (count[e] == 0 && e != 9) {
				bingo[l] = (char) (e + 97);
				l++;
			}
			e++;
		}

		// for(int j=0;j<25;j++){
		// System.out.println("bingo["+j+"]: "+bingo[j]);}

		e = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				play[i][j] = bingo[e];
				e++;
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(play[i][j] + " ");
			}
			System.out.println();
		}

		//String plain = "";
		StringBuilder plain = new StringBuilder("");
	
	
		for (int i = 0; i < p.length() - 1; i = i + 2) {
			
			char x = p.charAt(i);
			char y = p.charAt(i+1);
			
			plain.append(x);

			if (x == y) {
				
				//plain.append(p.substring(0, i + 1)).append("x").append(p.substring(i + 1, p.length()));
				//plain.append(p.charAt(i)).append('x').append(p.charAt(i+1));
				plain.append('x').append(y);
				//System.out.println("SAME: "+plain);
			} else {
				
				//plain.append(p.charAt(i)).append(p.charAt(i+1));
				//plain.append(p);
				plain.append(y);
				//System.out.println("DIFF: "+plain);
			}
			
		}
		
		if(p.length() % 2 != 0){
			plain.append(p.charAt(p.length()-1));
	}

		//System.out.println("MODIFIED PLAIN TEXT: " + plain);
		
		if (plain.length() % 2 != 0) {
			plain.append('x');
			//System.out.println("ODD!");
		}

		System.out.println("MODIFIED PLAIN TEXT: " + plain);
		String cipher = "";

		int s = 0, t = 0, u = 0, v = 0;
		for (int i = 0; i < plain.length() - 1; i = i + 2) {
			char a = plain.charAt(i);
			char b = plain.charAt(i + 1);
			for (int k = 0; k < 5; k++) {
				for (int j = 0; j < 5; j++) {
					if (play[k][j] == a) {
						s = k;
						t = j;
					}
					if (play[k][j] == b) {
						u = k;
						v = j;
					}
				}

			}

			if (s == u) {
				//System.out.println("CASE 1 ("+a+" "+b+"): SAME ROW!");
				int w = (t + 1) % 5;
				int x = (v + 1) % 5;
				cipher += play[s][w];
				cipher += play[s][x];

			}

			if (t == v) {
				//System.out.println("CASE 2 ("+a+" "+b+"): SAME COLUMN!");
				int w = (s + 1) % 5;
				int x = (u + 1) % 5;
				cipher += play[w][t];
				cipher += play[x][t];

			}

			if (s != u && t != v) {

				//System.out.println("CASE 3 ("+a+" "+b+") : DIFF. ROW N COLUMN!");
				cipher += play[s][v];
				cipher += play[u][t];

			}
		}

		System.out.println("CIPHER TEXT: " + cipher);
		sc.close();
	}

}

/*
Enter key: 
attack
Enter plain text: 
hellobrotherwhatsup
a t c k b 
d e f g h 
i l m n o 
p q r s u 
v w x y z 
MODIFIED PLAIN TEXT: helxlobrotherwhatsup
CIPHER TEXT: dfmwmiculbdfqxdbkqpq
*/

