package org.kidding.backjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EscapeMarble {

	//일단 지금처럼 풀면 왔던 경로를 되돌아가는 경우가 생김. visited[] 를 해주어야 함. 
	//이전에 풀었던  bfs, dfs 먼저 다시 풀어보고 이 문제 접근법 다시 익히기. 
	//한번에 움직이는 걸 생각해야하나.. 쭉 이동할건데 중간에 0 있으면 -1로 해주기. 
	// --> 그리고 dfs 시에 둘다 -1이면 끝! 둘중 하나가 -1이면 ㅇㅋ 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		String[][] arr = new String[x][y];
		int[][] place = new int[3][2];
		System.out.println(arr.length + " " +  arr[0].length);
		int depth = 0;
		
		//공백없이 잘라서 쓸 땐 그냥 split 하는 게 마음 편함. 
		for(int i=0; i<x; i++) {
			String[] temp = br.readLine().split("");
			for(int j=0; j<y; j++) {
				if(temp[j] == "R") {
					arr[i][j] = temp[j];
					place[0][0] = i;
					place[0][1] = j;
				}else if(temp[j] == "B") {
					arr[i][j] = temp[j];
					place[1][0] = i;
					place[1][1] = j;
				}else if(temp[j] == "0") {
					arr[i][j] = temp[j];
					place[2][0] = i;
					place[2][1] = j;
				}else {
					arr[i][j] = temp[j];
				}
			}
		}
		
//		dfs(arr, place, depth);
//		for(int i=0; i<x; i++) {
//			System.out.println(" ");
//			for(int j=0; j<y; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//		}	
		
		//dfs 함수 고고. B, R, 0 위치 담은 배열, depth
		
		
	}
	
	void dfs(String[][] arr, int[][] place, int depth, String direction) {
		
		if(place[0][0] == -1 || place[0][1] == -1) {
			if(place[1][0] != -1 && place[1][1] != -1) {
				//끝
			}else {
				//실패 
			}
		}
		
		if(place[1][0] == -1 || place[1][1] == -1) {
			//실패 . return -1
		}
		if(depth > 10) {
			//실패. return -1 
		}
		
		if(direction == "x") {
			//아래쪽 이동(x)
			if(arr[place[0][0]+1][place[0][1]] == "." || arr[place[0][0]+1][place[0][1]] == "B") {
				//열이 같고, B가 더 아래쪽에 있을 때(B가 먼저 이동할 때)
				if(place[0][1] == place[1][1] && place[0][0] < place[1][0]) {	
					place[1][0] = move(arr, place[1][0], place[0][1], "x+");
					place[0][0] = move(arr, place[0][0], place[0][1], "x+");
					dfs(arr, place, depth+1, "y");
				}else {								//열 다를 때
					place[0][0] = move(arr, place[0][0], place[0][1], "x+");
					place[1][0] = move(arr, place[1][0], place[0][1], "x+");	
					dfs(arr, place, depth+1, "y");
				}	
			};
			//위쪽 (x)
			if(arr[place[0][0]-1][place[0][1]] == "." || arr[place[0][0]-1][place[0][1]] == "B") {
				//열이 같고, B가 더 위쪽에 있을 때(B가 먼저 이동)
				if(place[0][1] == place[1][1] && place[0][0] > place[1][0]) {
					place[1][0] = move(arr, place[1][0], place[0][1], "x-");
					place[0][0] = move(arr, place[0][0], place[0][1], "x-");
					dfs(arr, place, depth+1, "y");
				}else {								//열 다를 때
					place[0][0] = move(arr, place[0][0], place[0][1], "x-");
					place[1][0] = move(arr, place[1][0], place[0][1], "x-");	
					dfs(arr, place, depth+1, "y");
				}				
			};			
		}else {
			// 오른쪽 (y)
			if(arr[place[0][0]][place[0][1]+1] == "." || arr[place[0][0]][place[0][1]+1] == "B") {
				//행이 같고 B가 더 오른쪽에 있을 때(B가 먼저 이동)
				if(place[0][0] == place[1][0] && place[0][1] < place[1][1]) {	//행이 같을 때
					place[1][1] = move(arr, place[0][0], place[1][1], "y+");
					place[0][1] = move(arr, place[0][0], place[0][1], "y+");
					dfs(arr, place, depth+1, "x");
				}else {								//행 다를 때
					place[0][1] = move(arr, place[0][0], place[0][1], "y+");
					place[1][1] = move(arr, place[0][0], place[1][1], "y+");
					dfs(arr, place, depth+1, "x");				
				}			
			};
			// 왼쪽 (y)
			if(arr[place[0][0]][place[0][1]-1] == "." || arr[place[0][0]][place[0][1]-1] == "B") {
				//행이 같고, B가 더 왼쪽에 있을 때(B가 먼저 이동)
				if(place[0][0] == place[1][0] && place[0][1] > place[1][1]) {	//행이 같을 때
					if(place[0][0] == place[1][0] && place[0][1] < place[1][1]) {	//행이 같을 때
						place[1][1] = move(arr, place[0][0], place[1][1], "y-");
						place[0][1] = move(arr, place[0][0], place[0][1], "y-");
						dfs(arr, place, depth+1, "x");
					}else {								//행 다를 때
						place[0][1] = move(arr, place[0][0], place[0][1], "y-");
						place[1][1] = move(arr, place[0][0], place[1][1], "y-");
						dfs(arr, place, depth+1, "x");				
					}						
				}		
			};	//왼쪽 (y)			
		}

		
	}
	
	int move(String[][] arr, int x, int y, String xy) {
		
		int ret = 0;
		
		if(xy == "x+") {						//아래로 이동할 때 				
			while(x<arr.length-1) {
				if(arr[x+1][y] == ".") {
					x++;
					ret = x;
				}else if(arr[x+1][y] == "0") {
					ret = -1;
					break;
				}else {
					break;
				}
			}
		}else if(xy == "x-"){
			
		}else if(xy == "y+") {
			
		}else {
		
		}
		
		return ret;
	}
	
	void isEmpty(int[][] arr) {
		
	}
	
}
