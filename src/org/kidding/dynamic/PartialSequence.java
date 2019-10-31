package org.kidding.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class PartialSequence {
	
	// https://baelanche.tistory.com/149
    static int n;
    static int s;
    static int[] arr;
    
    static boolean[] check;
    static int cnt = 0;
    static int depth = 0;	//탐색용
    static int r = 0; 		//r = 0일 때 추가
    		
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        s = sc.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        };
        check = new boolean[n];
        
        for(int i=1; i<=n; i++) {
            recursive(arr, check, depth, n, i);
        }
        System.out.println(cnt);
    }
    
    public static void recursive(int[] arr, boolean[] check, int depth, int n, int r) {
    	System.out.println("check = "+Arrays.toString(check)+", depth: "+depth+", n: "+n+", r: "+r);
    	int sum = 0;
    	if(r == 0) {
    		for(int i=0; i<n; i++) {
    			if(check[i] == true) {
    				sum += arr[i];
    			}
    		}
    		if(sum == s) cnt++;
    		return;
    	}
    	if(depth == n) {
    		return;
    	}else {
    		check[depth] = true;
    		recursive(arr, check, depth+1, n, r-1);
    		check[depth] = false;
    		recursive(arr, check, depth+1, n, r);
    	}
    	
    	
    	
    	
    	
    }
}
