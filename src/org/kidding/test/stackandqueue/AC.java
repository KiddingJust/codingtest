package org.kidding.test.stackandqueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;


public class AC {
	//R : 배열 순서 뒤집기
	//D : 첫 번째 꺼 버리기(배열 비어있으면 error출력)
	static String[] funcArr;
	static String[] inputArr;
	static int[] arr;
	static boolean isReverse;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		while(T != 0) {
			deque.clear();
			isReverse = false;
			funcArr = br.readLine().split("");
			int n = Integer.parseInt(br.readLine());
			String inputStr = br.readLine();
			inputArr = inputStr.substring(1, inputStr.length()-1).split(",");
			int first = 0;
			int last = inputArr.length-1;
			
			for(int i=0; i<n; i++) {
				 	deque.add(Integer.parseInt(inputArr[i]));
			}//for end 배열생성 끝 
			
			for(int i=0; i<funcArr.length; i++) {
				if(funcArr[i].equals("R")) {
//					System.out.println("reverse!!!!");
					isReverse = !isReverse;
				}else {
					if(!deque.isEmpty()) {
						if(isReverse) {
							deque.pollLast();
//							System.out.println(deque.pollLast());
						}else {
							deque.pollFirst();
//							System.out.println(deque.pollFirst());

						}
//						System.out.println("deque: " + deque);
					}else {
						sb.append("error");
						break;
					}
				}
				
				int dequeSize = deque.size();
//				System.out.println("deque: " + deque);
//				System.out.println("dequeSize: " + dequeSize);
//				System.out.println("i: " + i);
//				System.out.println("funcArr.length: " + funcArr.length);
				
//				if(dequeSize == 0) {
//					sb.append("[]"); // 혹은 error
//					break;
//				}
				
				if(i == funcArr.length-1) {
					sb.append("[");
					if(isReverse) {
						for(int j=0; j<dequeSize; j++) {
//							System.out.println("pollLast(): " + deque.pollLast() + ",");
							sb.append(deque.pollLast()+",");
						}
					}else {
						for(int j=0; j<dequeSize; j++) {
//							System.out.println(deque.pollFirst() + ",");
							sb.append(deque.pollFirst()+",");
						}
					}
					if(dequeSize != 0) {
						sb.delete(sb.length()-1, sb.length());	
					}
					sb.append("]");
				}
			}//함수 끝	
			if(T != 1){
				sb.append("\n");
			}
			T--;
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}

//테스트 케이스

//D
//1
//[3]
//RRRD
//4
//[1,2,3,4]
//
//
//1
//D
//1
//[3]
//
//
//4
//D
//1
//[3]
//D
//1
//[4]
//D
//0
//[]
//R
//0
//[]
//
//
//1
//R
//2
//[100,100]
