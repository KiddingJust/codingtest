package org.kidding.test.dynamic;

import java.util.Scanner;

public class EasyStep {

	//45656
	//-1 혹은 +1을 해준다. 끝. 
	//다이나믹 혹은 완전탐색으로 풀 수 있음. 음.. 그런가..?
	
	//계단 수: D[i][j] 길이가 i이면서 마지막숫자가 j인 계단 수의 개수
	//D[i][j] = D[i-1][j-1] + D[i-1][j+1]
	
	static long bill = 1000000000L;
	
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] D = new long[n+1][10];
		
		//길이가 1인 경우 갯수는 1개. 
		for (int j=1; j<=9; j++) {
			D[1][j] = 1;
		}
		
		//길이가 2 이상인 경우
		for (int i=2; i<=n; i++) {
			for (int j=0; j<=9; j++) {
				D[i][j] = 0;
				//마지막 숫자가 0인 경우에는 갯수 더할 수 없음.
				if (j-1 >= 0) {
					D[i][j] += D[i-1][j-1];
				}
				//마지막 숫자가 9인 경우에는 갯수 더할 수 없음.
				if (j+1 <= 9) {
					D[i][j] += D[i-1][j+1];
				}
				D[i][j] %= bill;
			}
		}
		
		long cnt = 0;
		for(int i=0; i<=9; i++) {
			cnt += D[n][i];
		}
		
		cnt %= bill;
		System.out.println(cnt);
		
		
	}

}
