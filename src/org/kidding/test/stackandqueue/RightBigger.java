package org.kidding.test.stackandqueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class RightBigger {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n =  Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		LinkedList<Integer> que = new LinkedList<Integer>();
		String[] arrString = br.readLine().split(" ");

		for(int i=0; i<n; i++) {
			que.add(Integer.parseInt(arrString[i]));
		}
		
		for(int i=0; i<que.size(); i++) {
			
			if(i == que.size()-1) {
				sb.append("-1");
				break;
			}
			
			for(int j=i+1; j<que.size(); j++) {
				
				if(que.get(i) < que.get(j)) {
					sb.append(que.get(j) + " ");
					break;
				}else {
					if(j == que.size()-1) {
						sb.append("-1 ");
					}
					continue;
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
