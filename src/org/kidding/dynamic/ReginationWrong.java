package org.kidding.dynamic;

public class ReginationWrong {

	public static void main(String[] args) {
		
		//d[i] = i일까지 출근할 때의 최대 금액
		//d[7] = 7일의 이익 + (1~6일까지의 이익) 또는 7일까지의 이익 <-- 이게 잘 이해가 안됨. 그럼 뒤에서부터 하자.
		
		int n = 7;
		int[] T = {0, 3, 5, 1, 1, 2, 4, 2};
		int[] P = {0, 10, 20, 10, 20, 15, 40, 200};
		
		int k = 1000;
		int[] D = new int[k];
		//날짜 지나치는지 확인용
		int days = 0;
		
		//D[1] = 0;
		//D[2] = 0;
		//D[3] = 10;
		//D[4] = 30 = D[3] + P[4]
		//D[5] = D[4]
		//D[6] = 40 (x) 
		//
		//D[i] = D[i] or D[i ~ i-1] + P[i]
		// 
		
		for(int i=n-1; i>0; i--) {
			// 9 = 2 + 7
			// 10 = 4 + 6
			// 7 =  2 + 5	- 여기부터  n과 같아짐
			// 5 = 1 + 4
			days = T[i] + i;
			if (days <= n) {
				// 날짜가 지나치지 않는 경우
				D[i] = Math.max(D[i+1], P[i] + D[days]);
			}else {
				// 지나치는 경우
				D[i] = D[i+1];
			}
			System.out.println("D[" + i + "]" + D[i]);
		}
		
		for(int i=0; i<10; i++) {
			System.out.println("D[" + i + "]"+ D[i]);
		}
	}
}
