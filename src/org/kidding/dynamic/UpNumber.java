package org.kidding.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class UpNumber {

	//오르막 수 - 동적 계획법
	//자리가 오름차순을 이루는 수
	//2234, 3678, 1119
	//수의 길이 N일 때 오르막 수의 수
	//N = 1 -> 9개
	//N = 2 -> 11 12 13... 22 23 .. 99.. 444
	//D[i][j] = D[i-1][1] + ... + D[i-1][j]
	private static long bill = 1000000000L;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] D = new long[n+1][10];
		
		for(int j=0; j<=9; j++) {
			D[1][j] = 1;
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=0; j<=9; j++) {
				for(int k=0; k<=j; k++) {
					D[i][j] += D[i-1][k];
					D[i][j] %= 10007;
				}				
			}
		}
		
		long cnt = 0;
		for(int i=0; i<=9; i++) {
			cnt += D[n][i];
		}
		//왜 %= 10007 을 2번이나 해줘야되는지는 이해 X
		cnt %= 10007;
		System.out.println(cnt);
		
		
	}

}
