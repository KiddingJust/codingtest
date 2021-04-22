package org.kidding.backjoon.sort;

import java.util.Scanner;

public class SelectionSort2750 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i] == arr[j]) {
					continue;
				}
				if(arr[i] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(arr[i]);
		}
	}
}
