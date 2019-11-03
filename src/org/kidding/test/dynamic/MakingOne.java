package org.kidding.test.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class MakingOne {
	
	public static int[] one;
	
	//cal 1부터 모든 경우의 수를 구하는 경우.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		one = new int[n+1]; //값 저장용
		System.out.println(cal(n));
		System.out.println(Arrays.toString(one));
	}
	
	public static int cal(int n) {

		if(n==1) {
			return 0;
		}
		
		if(one[n] > 0) {
		
			return one[n];
		}
		
		//cal4, cal3, cal2, cal1 순차적으로 실행됨.
		//여기서 cal10을 실행한다 치자. cal 10은 cal 9 + 1이 됨. 고로 3. 
		//그런데 뒤의 나누기 2를 해서 구하는 경우에는 그렇게 되지 않음. 4번이 나옴. temp는 더 작으므로 X.
		one[n] = cal(n-1) + 1;
		
		if (n%2 == 0 ) {
			int temp = cal(n/2) + 1;
			if (one[n] > temp) {
				one[n] = temp;
			}
		}
		
		if (n%3 == 0) {
			int temp = cal(n/3) + 1;
			if (one[n] > temp) {
				one[n] = temp;
			}
		}

		return one[n];
	}
}
