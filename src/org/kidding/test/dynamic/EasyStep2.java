package org.kidding.test.dynamic;

import java.util.Scanner;

public class EasyStep2 {

	//45656
	//-1 혹은 +1을 해준다. 끝. 
	//다이나믹 혹은 완전탐색으로 풀 수 있음. 음.. 그런가..?
	
	//계단 수: D[i][j] 길이가 i이면서 마지막숫자가 j인 계단 수의 갯
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//101, 121 123, 132 134.. 210 212, 231, 234
		//갯수 
		float cnt = 9;
		for(int i=0; i<n-1; i++) {
			cnt = cnt*2;
		}
		
		if(n != 1) {
			cnt = cnt-1 ;
		}
		System.out.println((int)cnt % 1000000000);
	}
	
	public int nextInt(int a) {

		return a-1;
	}
}
