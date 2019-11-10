package org.kidding.math;

import java.util.Scanner;

public class Eratoshenes {
	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int n = sc.nextInt();
        //false인 경우가 소수. true는 지워짐. 
        boolean[] check = new boolean[n+1];
        
        check[0] = check[1] = true;
        
        //1~100까지라 할 때, 11부터는 굳이 진행해줄 필요 없음. 
        for (int i=2; i*i <= n; i++) {
            if (check[i] == true) {
                continue;
            }
            //check[i]가 false이면 배수들을 모두 지워줌. 
            for (int j=i+i; j<=n; j+=i) {
                check[j] = true;
            }
        }
       
        for (int i=m; i<=n; i++) {
            if (check[i] == false) {
                System.out.println(i);
            }
        }
        
        
    }
}
