package org.kidding.dynamic;

import java.util.Arrays;

public class Combination {
	
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];
 
//        for(int i=1; i<=n; i++) {
//            comb(arr, visited, 0, n, i);
//        }
        
        System.out.println();
        
        for(int i=1; i<=n ;i++) {
            combination(arr, visited, 0, n, i);
        }
    }

    // 재귀 사용
    // 사용 예시 : comb(arr, visited, 0, n, r)
    static void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
    	System.out.println(Arrays.toString(visited) +", " + depth+", " + n+", " + r+")");
        if(r == 0) { 
            print(arr, visited, n);
            return;
        }
        if(depth == n) {
            return;
        } else {
            visited[depth] = true;
            comb(arr, visited, depth + 1, n, r - 1);
 
            visited[depth] = false;
            comb(arr, visited, depth + 1, n, r);
        }
    }
    
    // 백트래킹 사용
    // 사용 예시 : combination(arr, visited, 0, n, r)
    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
    	System.out.println(Arrays.toString(visited) +", " + start+", " + n+", " + r+")");

        if(r == 0) {
            print(arr, visited, n);
            return;
        } else {
            for(int i=start; i<n; i++) {
                visited[i] = true;
                combination(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }

    // 배열 출력
    static void print(int[] arr, boolean[] visited, int n) {
//        for(int i=0; i<n; i++) {
//            if(visited[i] == true)
//                System.out.print("arr[" + i + "]: " + arr[i] + " ");
//        }
        System.out.println();
    }

    
    

}
