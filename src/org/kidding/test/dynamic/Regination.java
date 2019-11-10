package org.kidding.test.dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Regination {

	public static void main(String[] args) throws NumberFormatException, IOException {

//		//�׽�Ʈ��
//		int n = 7;
//		int[] T = {0, 3, 5, 1, 1, 2, 4, 2};
//		int[] P = {0, 10, 100, 10, 20, 15, 40, 200};
//		int[] D = new int[30];
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] T = new int[n+1];
		int[] P = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			String[] str = br.readLine().split(" ");
			T[i] = Integer.parseInt(str[0]);
			P[i] = Integer.parseInt(str[1]);
		};
		
		//D[i]�� �ִ������ ����. D[i-1] <= D[i] �̹Ƿ� max ���� �׻� �����صΰ� �־�� ��.
		//P[2]�� 100�̶� ġ�� D[6]�� 100�� �Ǿ� �ִ��� ��. �̿� ���� ���� ����ؼ� �����ϰ� ���ϰ� �������־�� ��.
		// ������ ����� D[i] ���� ���� ���Ž�Ű�� D[i] �� �� ������ ū �� ��.
		//D[T[i] + i - 1] = MAX(max + P[i], D[T[i] + 1 - 1])
		//�밭 Ȯ�� 
		//D[1] = 0; D[3] = 10; max = 0;
		//D[2] = 0; D[6] = 100; max = 0;
		//D[3] = 0; D[3] = (10, D[3]) = 10, max = (D[3], max) = 10
		//D[4] = 10; D[4] = (10+20, 10) = 30, max = (D[4], max) = 30
		//D[5] = 30; D[6] = (30 + 15, 100) = 100; max = (D[5], max) = 30
		//D[6] = (max, D[6]) = 100, D[9] = (100 + 15, D[9]) = 100, max = (100, 30) = 100
		//D[7] = 100, D[8] = (100 + 200, 0) = 300, max = 100
		int max = 0; 
		int[] D = new int[30]; //T[n+1] + n + 1 �� �ִ밡 �ƴ� �� D[n] �� �װ� �ִ밡 �ƴϱ� ����. �˳���
		
		for(int i=1; i<=n; i++) {
			//���� ��¥������ max ���� D[i]�� �����صΰ� ����.
			D[i] = Math.max(max, D[i]);
			//System.out.println("max: " + max);
			//System.out.println("i: " + i + "arr: " + Arrays.toString(D));
			D[T[i]+i-1] = Math.max(max + P[i], D[T[i]+i-1]);
			//�ٽ� ���� ��¥������ max ��(���⼭�� D[i])�� ������ �� ���
			max = Math.max(D[i], max);
			//System.out.println("i: " + i + "arr: " + Arrays.toString(D));

		}
		
//		System.out.println(Arrays.toString(D));
		
		//�ִ� ���
		int answer = 0;
		for(int i=1; i<=n; i++) {
			if(D[i] >= answer) {
				answer = D[i];
			}
		}
		
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
				
	}
}
