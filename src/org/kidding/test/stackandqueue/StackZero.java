package org.kidding.test.stackandqueue;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class StackZero {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int sum = 0;

		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<count; i++) {
			int num = sc.nextInt();
			if(num == 0) {
				stack.pop();
			}else {
				stack.push(num);
			}
		}//for end
		
		Iterator it = stack.iterator();
		while(it.hasNext()) {
			sum += (int)it.next();
		}
		
		System.out.println(sum);
	}
}
