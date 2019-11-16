package org.kidding.test.stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class MakingStack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		
		int count = sc.nextInt();
		
		for(int i=0; i<count; i++) {
			String order = sc.next();
			
			if(order.equals("push")) {
				int num = sc.nextInt();
				stack.push(num);
			}else if (order.equals("pop")) {
				System.out.println(stack.isEmpty() ? -1 : stack.pop());
			}else if (order.equals("size")) {
				System.out.println(stack.size());
			}else if (order.equals("empty")) {
				System.out.println(stack.isEmpty() ? "empty" : "not empty");
			}else if (order.equals("top")) {
				System.out.println(stack.isEmpty() ? -1:stack.peek());
			}
		}
	}
}
