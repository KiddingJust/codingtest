package org.kidding.test.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backpack_timeout {
	
	static int sum;
	static int value;
	static int max;
	static int[][] arr;
	static int start;
	
	//완전탐색처럼 풀어선 X. 
	//점화식을 세워야해. 
	public static void main(String[] args) throws IOException {
		
		//무게 W, 가치 V
		//무게의 합 <= K. 이 범위 안에서 최대치를 구하기.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		arr = new int[n][2];
		
		
		for(int i=0; i<n; i++) {
			String[] wv = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(wv[0]);
			arr[i][1] = Integer.parseInt(wv[1]);
		}
		
		calculate(arr, 0, n, k, 0);		
		
		System.out.println(max);
		
	}

	//합이 K보다 작으면 다음 꺼 탐색
	//합이 K보다 크면 패스하고 다음 꺼 탐색 
	static void calculate(int[][] arr, int index, int n, int k, int start) {	

//		System.out.println("--------------------------------");
//		System.out.println("index: " + index);
//		System.out.println("start: " + start);
//		System.out.println("sum: " + sum);
//		System.out.println("value: " + value);
//		System.out.println("max: " + max);
//		System.out.println("--------------------------------");
		
		if(start == n) {
//			System.out.println("끝");
			return;
		}
		
		if(index >= n) {
			//앞에 꺼 탐색.
			sum = 0;
			value = 0;
			start += 1;
			calculate(arr, start, n, k, start);
		}else {
		sum += arr[index][0];

		if(k >= sum) {
			value += arr[index][1];
		}else {
			//다음 인덱스 탐색 
			calculate(arr, index+1, n, k, start);
		}
		
		if(max <= value) {
			max = value;
		}
		
		//다음 인덱스 탐색
		calculate(arr, index+1, n, k, start);
		}
	}

}
