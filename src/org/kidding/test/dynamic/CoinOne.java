package org.kidding.test.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoinOne {

	// n, k 
	// n개의 동전을 이용해서 k개의 가치를 만들기. 각 동전의 가치는 다름. 
	// 1,2,5 -> 10의 경우 (2*5), (1*2 + 2*4) + .. 6가지 +
	// 5 1개인 경우 3가지,  5 2개인 경우 1가지. 
	//   1, 2, 3, 4, 5, 6, 7, 8, 9, 10
	//1  1  1  1  1  1  1  1  1  1  1
	//2  1  2  2  3  3  4  4  5  5  6
	//5  1  2  2  3  4  5  6  7  8  10
	//D[k][n] = D[k][n-1] + D[k-v[n]][n]
	//D[n][k] = D[n-1][k] + D[n][k-value[n]]
	//D[5][3] = D[5][2] + D[0][3]
	//D[2][2] = D[2][1] + D[0][2]
	//D[0][i]를 모두 '1'로 맞추어주면 됨. 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		
		int[][] D = new int[n+1][k+1];
		int[] value = new int[n+1];
		value[0] = 0;
		for(int i=1; i<=n; i++) {
			//value[1] = 1, [2] = 2, [3] = 5
			value[i] = Integer.parseInt(br.readLine());
		}
		
		//D[n][k]
		//D[0][1] = 0;
		//D[1][0] = 1; D[1][1] = D[0][1] + D[1][0]
		//D[2][0] = 1; D[2][1] = D[1][1] + D[2][-1] = 

		D[0][0] = 0;
		for(int i=1; i<=k; i++) {
			D[0][i] = 0;
			for(int j=1; j<=n; j++) {
				D[j][0] = 1;
				int v = i-value[j];
				if(v < 0) {
					v = 0;
					D[j][i] = D[j-1][i];
					continue;
				}else {
					D[j][i] = D[j-1][i] + D[j][v];
				}
//				System.out.println("D[" + j + "][" + 0 + "]: " + D[j][0]);
//				System.out.println("D[" + j + "][" + i + "]: " + D[j][i]);
			}
		}
		
//		//생성 배열 확인용 
//		StringBuffer sb = new StringBuffer();
//		for(int i=0; i<=k; i++) {
//			sb.append(i + " ");
//		}
//		sb.append("\n");
//		for(int i=0; i<=n; i++) {
//			sb.append("\n");
//			for(int j=0; j<=k; j++) {
//				sb.append(D[i][j] + " ");
//			}
//		}
		System.out.println(D[n][k]);
		

	}
}
