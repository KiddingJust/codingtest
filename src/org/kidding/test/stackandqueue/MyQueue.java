package org.kidding.test.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MyQueue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int num = 0;
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i=0; i<cnt; i++) {
			String order = sc.next();
			if (order.equals("push")) {
				num = sc.nextInt();
				que.add(num);
			}else if(order.equals("pop")){
				System.out.println(que.isEmpty()?-1:que.poll());
			}else if(order.equals("size")){
				System.out.println(que.size());
			}else if(order.equals("empty")){
				System.out.println(que.isEmpty()?1:0);
			}else if(order.equals("front")){
				System.out.println(que.isEmpty()?-1:que.peek());
			}else if(order.equals("back")){
				System.out.println(que.isEmpty()?-1:num);
			}
		}
	}
	
}
