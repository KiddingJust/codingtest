package org.kidding.test.dynamic;

import java.util.Arrays;

public class Fibonacci {
	
	static int memo[] = new int[100];
	static int d[] = new int[100];
	
	public static void main(String[] args) {
		System.out.println(fibonacci(5));
		System.out.println(Arrays.toString(memo));
	}
	
	//Top-down
	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			memo[n] = fibonacci(n-1)+fibonacci(n-2);
			return memo[n];
		}
	}
	
	//Bottom-up
	public static int fibonacci2(int n) {
		d[0] = 0;
		d[1] = 1;
		for (int i=2; i<=n; i++) {
			d[i] = d[i-1] + d[i-2];
		}
		return d[n];
	}
	
}
