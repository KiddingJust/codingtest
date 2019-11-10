package org.kidding.test.dynamic;

import java.util.Scanner;

public class ReginationRecursive {

    static int n;
    static int s;
    static int a[];
    static int cnt = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        s = sc.nextInt();
        a = new int[n];
        for(int i=0; i<n; i++)
           a[i] = sc.nextInt();
        
        recursive(0, 0);
        System.out.println(cnt);
    }
    
    public static void recursive(int idx, int sum) {
    	System.out.println("recursive(" + idx + ", " + sum + ")");
        if(idx >= n) return;
        sum += a[idx];
        System.out.println("sum: " + sum);
        if(sum == s) cnt++;
        
        //idx+1 해주면서 탐색 구간 늘리기. 
        //이건 진짜 어렵다 이해하기. 
        recursive(idx + 1, sum - a[idx]);
        recursive(idx + 1, sum);
    }
}
