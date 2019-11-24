package org.kidding.test.stackandqueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class AC_Timeout {
	//R : 배열 순서 뒤집기
	//D : 첫 번째 꺼 버리기(배열 비어있으면 error출력)
	static String[] funcArr;
	static String[] inputArr;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		while(T != 0) {
			deque.clear();
			funcArr = br.readLine().split("");
			int n = Integer.parseInt(br.readLine());
			inputArr = br.readLine().split(",");
			for(int i=0; i<n; i++) {
				if(i==0) {
					deque.add(Integer.parseInt(inputArr[i].split("")[1]));
				}else if(i==(n-1)) {
					deque.add(Integer.parseInt(inputArr[i].split("")[0]));					
				}else {
					deque.add(Integer.parseInt(inputArr[i]));
				}
			}//for end 배열생성 끝 
			
			
			for(int i=0; i<funcArr.length; i++) {
				if(funcArr[i].equals("R")) {
					reverse(deque, n);
				}else {
					if(!deque.isEmpty()) {
						deque.pollFirst();
					}else {
						sb.append("error\n");
						break;
					}
				}
				if(i == funcArr.length-1) {
//					System.out.println("for문 후 deque: " + deque);
					sb.append(deque);
//					for(int j=0; j<deque.size(); j++) {
//						sb.append(deque.pollFirst()+",");
//					}
					sb.append("\n");
				}
			}//함수 끝			
			
			
			T--;
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		
	}
	
	static void reverse(Deque<Integer> deque, int n) {
		Queue<Integer> temp = new LinkedList<Integer>();
		for(int i=0; i<n; i++) {
			temp.add(deque.pollLast());
		}
		for(int i=0; i<n; i++) {
			deque.add(temp.poll());
		}
		
	}
}
