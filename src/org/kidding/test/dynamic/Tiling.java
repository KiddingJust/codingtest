package org.kidding.test.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class Tiling {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] count = new int[1001];
		
		//2x2의 경우 2가지의 방법이 있으므로 count[0] = 1로 셋팅
		count[0] = 1;
		count[1] = 1;
		
		//이번엔 bottom-up으로 풀어보기. 피보나치. 
		for(int i=2; i<=n; i++) {
			count[i] = count[i-1] + count[i-2];
			count[i] %= 10007;
		}
		System.out.println(count[n]);
	}
}
