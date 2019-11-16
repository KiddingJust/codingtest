package org.kidding.test.stackandqueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PrinterQueue_wrong {

	//테스트 케이스 만들기
	//arr만들어서 sort로 순서 정하기
	//queue에 삽입하고 원하는 순서만큼 출력하기. 
	//단 같은 게 있다면 마지막 껄로 
	// isMax 메서드 구현. 해당 값들을 받아서 max인지 아닌지를 판단. 
	// int index, int max
	// 1 4 A 5 2 -> 4 A 5 2 1 -> A 5 2 1 4 -> 5 2 1 4 A Max면 poll(); 그리고 다시 isMax
	// 만약 max가 아니면 현재 순서에서 -1 해주기 (단 0이면 전체 길이-1 로 변경)
	// 2 1 4 A -> 1 4 A 2 -> 4 A 2 1
	// A 2 1 -> 2 1 A
	// 1 A
	static String read;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n =  Integer.parseInt(br.readLine());
		
		Queue<Integer> que = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		while (n>0) {
			read = br.readLine();
			String[] temp = read.split(" ");
			int size = Integer.parseInt(temp[0]);
			int index = Integer.parseInt(temp[1]);
			
//			System.out.println("size: " + size);
//			System.out.println("index: " + index);
			
			int[] arr = new int[size];
			
			String tempString = br.readLine();
			for(int i=0; i<size; i++) {
				arr[i] = Integer.parseInt(tempString.split(" ")[i]);
			}
			int pickNum = arr[index];
			Arrays.sort(arr);
//			System.out.println("sorted arr: " + Arrays.toString(arr));
			for(int i=size-1; i>=0; i--) {
				que.add(arr[i]);
			}
						
			int answer = 0;
			
			for(int i=1; i<=size; i++) {
				if(que.poll() == pickNum) {
					answer = i;
				}
			}
			sb.append(answer + "\n");

			n--;
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
