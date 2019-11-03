package org.kidding.test.dynamic;

import java.util.Scanner;

public class Triangle2 {
	
	static int[][] triangle;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		triangle = new int[n][n];
		
		for (int i=0; i<n; i++) {
			for(int j=0; j<i+1; j++) {
				triangle[i][j] = sc.nextInt();
				
				//i가 0인경우에는 pass
				if (i == 0) {
					max = triangle[i][j];
					continue;
				}
				if (j == 0) { 
				    triangle[i][j] += triangle[i-1][j];
				} else if (j == i) {
				    triangle[i][j] += triangle[i-1][j-1];
				} else {
				    triangle[i][j] = max(triangle[i][j] + triangle[i-1][j-1], triangle[i][j] + triangle[i-1][j]);
				}
				
				if (max < triangle[i][j]) {
					max = triangle[i][j];
				}	
			}
		};//for i end
		
		System.out.println(max);
	
	}
	
	static int max(int a, int b) {		
		int maxValue = 0;
		if (a >= b) {
			maxValue = a;
		}else if (a < b) {
			maxValue = b;
		}
		return maxValue;
	}
		

}
