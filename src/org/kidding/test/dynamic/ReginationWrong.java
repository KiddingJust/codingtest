package org.kidding.test.dynamic;

public class ReginationWrong {

	public static void main(String[] args) {
		
		//d[i] = i�ϱ��� ����� ���� �ִ� �ݾ�
		//d[7] = 7���� ���� + (1~6�ϱ����� ����) �Ǵ� 7�ϱ����� ���� <-- �̰� �� ���ذ� �ȵ�. �׷� �ڿ������� ����.
		
		int n = 7;
		int[] T = {0, 3, 5, 1, 1, 2, 4, 2};
		int[] P = {0, 10, 20, 10, 20, 15, 40, 200};
		
		int k = 1000;
		int[] D = new int[k];
		//��¥ ����ġ���� Ȯ�ο�
		int days = 0;
		
		//D[1] = 0;
		//D[2] = 0;
		//D[3] = 10;
		//D[4] = 30 = D[3] + P[4]
		//D[5] = D[4]
		//D[6] = 40 (x) 
		//
		//D[i] = D[i] or D[i ~ i-1] + P[i]
		// 
		
		for(int i=n-1; i>0; i--) {
			// 9 = 2 + 7
			// 10 = 4 + 6
			// 7 =  2 + 5	- �������  n�� ������
			// 5 = 1 + 4
			days = T[i] + i;
			if (days <= n) {
				// ��¥�� ����ġ�� �ʴ� ���
				D[i] = Math.max(D[i+1], P[i] + D[days]);
			}else {
				// ����ġ�� ���
				D[i] = D[i+1];
			}
			System.out.println("D[" + i + "]" + D[i]);
		}
		
		for(int i=0; i<10; i++) {
			System.out.println("D[" + i + "]"+ D[i]);
		}
	}
}
