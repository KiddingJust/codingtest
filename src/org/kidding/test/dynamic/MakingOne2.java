package org.kidding.test.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class MakingOne2 {
	
	public static int[] one;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		one = new int[n+1]; //값 저장용
		System.out.println(cal(n));
		System.out.println(Arrays.toString(one));
	}
	
	public static int cal(int n) {
		System.out.println("실행되는 n: " + n);
		//3으로 나누거나 2로 나누거나 -1 해주거나. 
		//재귀 함수로 풀어가기. 빠른 연산은 /3 -> /2 -> -1 순
		//각 계산 결과는 배열 one 에 저장. 
		
		//1이면 연산 횟수는 0
		if(n==1) {
			return 0;
		}
			
		if (n%2 == 0 ) {	
			int temp = cal(n/2) + 1;
			one[n] = temp;			
		} else if (n%3 == 0) {
			int temp = cal(n/3) + 1;
			one[n] = temp;	
		} else {
			one[n] = cal(n-1) + 1;
		}
		return one[n];
	}
}
