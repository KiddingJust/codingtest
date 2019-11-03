package org.kidding.test.stackandqueue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Parenthesis {
	
	public static void main(String[] args) {
		//스택?
		//여는 괄호 나오면 push. 닫는 괄호 나오면 pop. 
		//pop 했는데 Stack 비어있으면 X.
		//연산 끝났는데 스택이 비어있지 않으면 X.
		
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		String[] success = new String[count];
		
		for(int i=0; i<count; i++) {
			Stack<Character> stack = new Stack<Character>();
			String str = sc.next();
			boolean yn = true;
			
			for(int j=0; j<str.length(); j++) {
				char c = str.charAt(j);
				
				if(c == '(') {
					stack.push('(');
					//System.out.println(stack);
				}else {
					if(stack.isEmpty()) {
						//System.out.println("여기도 들");
						yn = false;
						break;
					}
					stack.pop();
					//System.out.println(stack);
				}
			}//for end
//			System.out.println("yn: " + yn);
//			System.out.println("stack: " + stack);
			if(yn == true && stack.isEmpty()) {
				success[i] = "YES";
			}else {
				success[i] = "NO";
			}
			//System.out.println(Arrays.toString(success));
		}//for end
		
		for(String i:success) {
			System.out.println(i);
		}
		
	}
}
