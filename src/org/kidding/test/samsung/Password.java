package org.kidding.test.samsung;

import java.util.Arrays;
import java.util.Scanner;

public class Password {
	
	static String text;
	
	static String toRight(String t, int c) {
		if (c==0) {
			//System.out.println("real text: " + t);
			return t;
		}
		String[] tempText = t.split("");
		String end = tempText[tempText.length-1];
		
		String[] realT = new String[tempText.length];
		for(int i=0; i<tempText.length-1; i++) {
			realT[i+1] = tempText[i];
		}
		realT[0] = end;
		t = "";
		
		for(int i=0; i<realT.length; i++) {
			t += (realT[i]);
		}
		//System.out.println("real text: " + t);		
		return t;
	}
	
	static int cal(String[] hex, int len ) {
		int realAnswer = 0; 
		
		
		for(int i=0; i <len ; i++ ) {
			String splNum = hex[i];
			if(splNum.equals("A")) {
				splNum = "10";
			}else if(splNum.equals("B")) {
				splNum = "11";
			}else if(splNum.equals("C")) {
				splNum = "12";
			}else if(splNum.equals("D")) {
				splNum = "13";
			}else if(splNum.equals("E")) {
				splNum = "14";
			}else if(splNum.equals("F")) {
				splNum = "15";
			}
			
			int plus = (int) (Integer.parseInt(splNum) * Math.pow(16, len-i-1));
			realAnswer += plus;
		}
		return realAnswer;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		sc.nextLine();
		String[][] c = new String[num][3];
		
		for(int i=0; i<num; i++) {
			String nk = sc.nextLine();
			String input = sc.next();
			
			c[i][0] = nk.split(" ")[0];	//N
			c[i][1] = nk.split(" ")[1];	//K
			c[i][2] = input;
			
			sc.nextLine();
		}
		
		int t=0;

		while(t<num) {
			int k = Integer.parseInt(c[t][1]);
			
			int spl = Integer.parseInt(c[t][0]) / 4;
			String[] test = new String[spl*4];

			int a = 0;
			int index = 0;
			text = c[t][2];

			for(int i=0; i< spl; i++) {
				
				text = toRight(text, i);

				while(a < spl*4) {

					if (a == spl*3) {
						test[index] = text.substring(a);
					} else {
						test[index] = text.substring(a, a+spl);
					}
					a = a+spl;
					index++;
				}
				a=0;
			}	
			Arrays.sort(test);
			String[] A = new String[test.length];
			int j = 0;
			for(int i=test.length-1; i>=0; i--) {
				A[j] = test[i];
				j++;
			}
//			System.out.println("afterSort : " + Arrays.toString(A));

			j=0;
			String[] answer = new String[28];
			
			for(int i=0; i<A.length-1; i++) {
				if(A[i].equals(A[i+1])) {
					i++;
				}

				answer[j] = A[i];
				answer[j+1] = A[i+1];
				j++;		
			}
			
//			System.out.println("중복제거후 : " + Arrays.toString(answer));		

			String[] hex = answer[k-1].split("");
			int len = hex.length;
			int realAnswer = cal(hex, len); 
		
			System.out.println("#"+(t+1)+" "+ realAnswer);
		t++;
		}
	}
	
}
