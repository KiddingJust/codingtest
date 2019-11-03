package org.kidding.test.dynamic;

import java.util.Scanner;

public class BuyingCard {
	
	public static void main(String[] args) {
		// N개의 카드라면 P1부터 PN까지 카드팩이 있음. 
		// 1+2+ ... +N의 합으로 N을 만드는 경우의 수 구하기. 
		// 1 = 1
		// 2 = 1+1, 2 
		// 3 = 1+1+1, 1+2, 3
		// 4 = 1+1+1+1, 1+1+2, 1+3, 2+2, 4 
		// 5 = 5, 4+1, 3+2, 3+1+1, 2+1+1+1, 2+2+...
		// 이렇게 구해서는 답이 없...

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        //카드 배열 만들기. 
        //[0, 1, 5, 6, 7]
        int[] card = new int[n+1];
        for (int i=1; i<=n; i++) {
            card[i] = sc.nextInt();
        }
        
        //최댓값 배열 만들기. 배열을 만들 때 기본값은 모두 0. 
        
        //d[1]은 1개 구매할 때의 최댓값으로 1
        //d[2]는 2개 구매할 때의 최댓값으로 5 -> d[2] = d[1] + card[1], d[2] = d[0] + card[2] 중 최댓값. 
        //d[3]는 3개 구매할 때의 최댓값으로 6,
        //d[4]는 4개 구매할 때의 최댓값으로 10
        
        int[] d = new int[n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                if (d[i] < d[i-j] + card[j]) {
                    d[i] = d[i-j] + card[j];
                }
            }
        }
        
        System.out.println(d[n]);
	}

	
}
