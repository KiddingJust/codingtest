package org.kidding.dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Regination {

	public static void main(String[] args) throws NumberFormatException, IOException {

//		//테스트용
//		int n = 7;
//		int[] T = {0, 3, 5, 1, 1, 2, 4, 2};
//		int[] P = {0, 10, 100, 10, 20, 15, 40, 200};
//		int[] D = new int[30];
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] T = new int[n+1];
		int[] P = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			String[] str = br.readLine().split(" ");
			T[i] = Integer.parseInt(str[0]);
			P[i] = Integer.parseInt(str[1]);
		};
		
		//D[i]는 최대수입을 저장. D[i-1] <= D[i] 이므로 max 값도 항상 저장해두고 있어야 함.
		//P[2]가 100이라 치면 D[6]가 100이 되어 최댓값이 됨. 이에 조건 없이 계속해서 저장하고 비교하고 갱신해주어야 함.
		// 이전에 저장된 D[i] 값과 현재 갱신시키는 D[i] 값 중 무엇이 큰 지 비교.
		//D[T[i] + i - 1] = MAX(max + P[i], D[T[i] + 1 - 1])
		//대강 확인 
		//D[1] = 0; D[3] = 10; max = 0;
		//D[2] = 0; D[6] = 100; max = 0;
		//D[3] = 0; D[3] = (10, D[3]) = 10, max = (D[3], max) = 10
		//D[4] = 10; D[4] = (10+20, 10) = 30, max = (D[4], max) = 30
		//D[5] = 30; D[6] = (30 + 15, 100) = 100; max = (D[5], max) = 30
		//D[6] = (max, D[6]) = 100, D[9] = (100 + 15, D[9]) = 100, max = (100, 30) = 100
		//D[7] = 100, D[8] = (100 + 200, 0) = 300, max = 100
		int max = 0; 
		int[] D = new int[30]; //T[n+1] + n + 1 이 최대가 아닌 건 D[n] 이 그게 최대가 아니기 때문. 넉넉히
		
		for(int i=1; i<=n; i++) {
			//이전 날짜까지의 max 값을 D[i]에 저장해두고 시작.
			D[i] = Math.max(max, D[i]);
			//System.out.println("max: " + max);
			//System.out.println("i: " + i + "arr: " + Arrays.toString(D));
			D[T[i]+i-1] = Math.max(max + P[i], D[T[i]+i-1]);
			//다시 이전 날짜까지의 max 값(여기서는 D[i])을 저장한 후 계산
			max = Math.max(D[i], max);
			//System.out.println("i: " + i + "arr: " + Arrays.toString(D));

		}
		
//		System.out.println(Arrays.toString(D));
		
		//최댓값 출력
		int answer = 0;
		for(int i=1; i<=n; i++) {
			if(D[i] >= answer) {
				answer = D[i];
			}
		}
		
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
				
	}
}
