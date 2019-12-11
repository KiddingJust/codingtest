package org.kidding.test.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//틀림
//DFS, BFS로 풀어야함. 
public class DownHill1211 {
	
	//세로 M, 가로 N	
	//D[M][N] = D[M][N-1] + D[M-1][N]
	//근데 조건문이 붙음. 
	//if P[M][N] < P[M][N-1] then temp += D[M][N-1]
	//if P[M][N] < P[M-1][N] then temp += D[M-1][N]
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] MN = br.readLine().split(" ");
		int M = Integer.parseInt(MN[0]);
		int N = Integer.parseInt(MN[1]);
		
		int[][] P = new int[M][N];
		int[][] D = new int[M][N];

		for(int i=0; i<M; i++) {
			String[] tempStr = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				P[i][j] = Integer.parseInt(tempStr[j]);
			}
		}
		
		D[0][0] = 0;
		for(int i=1; i<N; i++) {
			if(P[0][i] < P[0][i-1]) {
				D[0][i] = 1;
			}else {
				D[0][i] = 0;
				break;
			}
		}

		for(int i=1; i<M; i++) {
			if(P[i][0] < P[i-1][0]) {
				D[i][0] = 1;
			}else {
				D[i][0] = 0;
				break;
			}
		}
		
		for(int i=1; i<M; i++) {
			for(int j=1; j<N; j++) {
				
				if (P[i][j] < P[i][j-1]) {
					D[i][j] += D[i][j-1];
				}
				
				if (P[i][j] < P[i-1][j]) {
					D[i][j] += D[i-1][j];
				}
			}
			for(int k=1; k<N-1; k++) {
				if(P[i][k] < P[i][k+1]) {
					D[i][k] += D[i][k+1];
				}
			}
		}
		
		for(int i=0; i<M-1; i++) {
			for(int j=0; j<N; j++) {
				if(P[i][j] < P[i+1][j]) {
					D[i][j] += D[i+1][j];
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			sb.append("\n");
			for(int j=0; j<N; j++) {
				sb.append(D[i][j] + " ");
			}
		}
		
		System.out.println(sb.toString());
		System.out.println(D[M-1][N-1]);
		
	}
}
