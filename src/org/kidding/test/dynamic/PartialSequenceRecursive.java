package org.kidding.test.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class PartialSequenceRecursive {
	
	// https://baelanche.tistory.com/149
    static int n;
    static int s;
    static int arr[];
    static int cnt = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        s = sc.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        recursive(0, 0);
        System.out.println(cnt);
    }
    
    public static void recursive(int idx, int sum) {
    	System.out.println("recursive(int " + idx + ", " + sum+")");
    	if(idx >= n) {
    		System.out.println("stop!");
    		return;
    	}
        sum += arr[idx];
        if(sum == s) { 
        	System.out.println("cnt up!");
        	cnt++;
        };
        System.out.println("after -> sum: " + sum + ", idx: " + idx);
        recursive(idx + 1, sum - arr[idx]);
        recursive(idx + 1, sum);
    }
}
