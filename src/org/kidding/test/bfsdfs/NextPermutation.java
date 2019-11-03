package org.kidding.test.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NextPermutation {
		
		//일단 입력받는다. -> 그걸 배열에 넣는다
		//a[i-1] < a[i]이면 i 저장
		//가장 큰 i보다 큰 j 중에서 a[i-1] < a[j] 를 찾고 그중 가장 큰 j 구하기
		// i와 j를 swap. 
		// 그 다음에 a[i]부터 정렬해주면 되는데 어케 정렬할지는 모르겠음!. 

	public static boolean nextPermutation(int[] permu) {
		
		int i = permu.length-1;
		//permu[i-1]<permu[i]인 최대 i값 찾기. 
		while(i>0 && permu[i-1]>=permu[i]) {
			i--;
		}
		//54321 과 같은 수는 다음 순열이 존재 X
		if (i == 0) {
			return false;
		}
		
		int j = permu.length-1;
		//j>=i 이면서 permu[j] > permu[i-1] 찾기.  
		while(permu[j] <= permu[i-1]) {
			j --;
		}
		
		//swap
		int temp = permu[i-1];
		permu[i-1] = permu[j];
		permu[j] = temp;
		
		//i-1 다음 인덱스 i부터 쭉 스왑해주기.
		j = permu.length -1;
		while(i < j) {
			temp = permu[i];
			permu[i] = permu[j];
			permu[j] = temp;
			i ++;
			j --;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] permu = new int[n];
		
        StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<n; i++) {
	        permu[i] = Integer.parseInt(st.nextToken());
		}
		
		if(nextPermutation(permu)) {
			for(int i=0; i<n; i++) {
				sb.append(permu[i] + " ");
			}
		}else {
			sb.append(-1 + " ");
		}
		
        sb.delete(sb.length()-1, sb.length());
        bw.write(sb.toString());
        bw.flush();
        bw.close();	
		
	}
}
