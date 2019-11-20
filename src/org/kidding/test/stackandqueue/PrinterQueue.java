package org.kidding.test.stackandqueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class PrinterQueue {

	// isMax 메서드 구현. 해당 값들을 받아서 max인지 아닌지를 판단. 
	// int index, int value;
	// 1 4 A 5 2 -> 4 A 5 2 1 -> A 5 2 1 4 -> 5 2 1 4 A Max면 poll(); 그리고 다시 isMax
	// 만약 max가 아니면 현재 순서에서 -1 해주기 (단 0이면 전체 길이-1 로 변경)
	// 2 1 4 A -> 1 4 A 2 -> 4 A 2 1
	// A 2 1 -> 2 1 A
	// 1 A
	static int cnt;
	static int index;
	static int size;
	static String[] temp;
	static String[] arrString;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n =  Integer.parseInt(br.readLine());
		
		LinkedList<Integer> que = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		while(n-- != 0) {
			
			temp = br.readLine().split(" ");
			size = Integer.parseInt(temp[0]);
			index = Integer.parseInt(temp[1]);
			arrString = br.readLine().split(" ");

			boolean isMax = false;
			cnt = 0;
			que.clear();

			for(int i=0; i<size; i++) {
				que.add(Integer.parseInt(arrString[i]));
			}
		    
			
			while(!isMax) {
				
				for(int i=0; i<que.size(); i++) {
					//System.out.println(que.get(i));
					if(que.peek() >= que.get(i)) {
						isMax = true;
					}else {
						isMax = false;
						break;
					}
				}
				
				if(isMax) {
					que.poll();
					cnt ++;
					if(index == 0) {
						break;
					}else {
						index--;
						isMax = false;
					}
				}else {
					int pollNum = que.poll();
					que.add(pollNum);
					
					if(index == 0) {
						index = size-1;
					}else {
						index--;
					}
				}
			}
			sb.append(cnt + "\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
