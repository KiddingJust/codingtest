package org.kidding.test.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class Triangle {
	
	static int[][] dp;
	static int[][] triangle;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		triangle = new int[n][n];
		dp = new int[n][n];
		
		for (int i=0; i<n; i++) {
			for(int j=0; j<i+1; j++) {
				triangle[i][j] = sc.nextInt();
			}
		};
		
		for (int i=0; i<n; i++) {
			System.out.println(Arrays.toString(triangle[i]));
		};
		
		int[] answer = new int[n];
		
		for(int i=0; i<n; i++) {
			answer[i] = cal(n-1, i);
		}
		
		Arrays.sort(answer);
		System.out.println(Arrays.toString(answer));
		System.out.println(answer[n-1]);
	}
	
	static int cal(int i, int j) {		
		System.out.println("실행: " + i + " " + j );
		
		if (i == 1) {
			dp[i][j] = triangle[i][j] + triangle[0][0];
			System.out.println("dp1: " + dp[i][j]);
			return dp[i][j];
		}	
				
		if (j == 0) { 
		    dp[i][j] = triangle[i][j] + cal(i-1, j);
		} else if (j == i) {
		    dp[i][j] += triangle[i][j] + cal(i-1, j-1);
		} else {
		    dp[i][j] = max(triangle[i][j] + cal(i-1, j-1), triangle[i][j] + cal(i-1, j));
		}
		
		System.out.println("dp2: " + dp[i][j]);
		return dp[i][j];
			
	}
		
	
	
	static int max(int a, int b) {		
		int maxValue = 0;
		if (a > b) {
			maxValue = a;
		}else if (a < b) {
			maxValue = b;
		}
		return maxValue;
	}
		

}
