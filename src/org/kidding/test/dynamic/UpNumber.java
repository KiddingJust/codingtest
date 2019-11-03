package org.kidding.test.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class UpNumber {

	//������ �� - ���� ��ȹ��
	//�ڸ��� ���������� �̷�� ��
	//2234, 3678, 1119
	//���� ���� N�� �� ������ ���� ��
	//N = 1 -> 9��
	//N = 2 -> 11 12 13... 22 23 .. 99.. 444
	//D[i][j] = D[i-1][1] + ... + D[i-1][j]
	private static long bill = 1000000000L;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] D = new long[n+1][10];
		
		for(int j=0; j<=9; j++) {
			D[1][j] = 1;
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=0; j<=9; j++) {
				for(int k=0; k<=j; k++) {
					D[i][j] += D[i-1][k];
					D[i][j] %= 10007;
				}				
			}
		}
		
		long cnt = 0;
		for(int i=0; i<=9; i++) {
			cnt += D[n][i];
		}
		//�� %= 10007 �� 2���̳� ����ߵǴ����� ���� X
		cnt %= 10007;
		System.out.println(cnt);
		
		
	}

}
