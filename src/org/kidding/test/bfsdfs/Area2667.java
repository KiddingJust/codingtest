package org.kidding.test.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Area2667 {

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static int[][] arr;
	static int n;
	static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static int num;		    //단지의 수
    static int cnt;			//단지에 속한 가구의 수
    static ArrayList<Integer> cntArr = new ArrayList<Integer>();
    
   
    
	//DFS로 탐색.
	//위, 아래, 오른쪽, 왼쪽 으로 옮길 때 1이면 재탐색
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = stoi(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			String[] temp = br.readLine().split("");
			for(int j=0; j<n; j++) {
				arr[i][j] = stoi(temp[j]);
			}
		}
//		생성된 배열 확인용
//		for(int i=0; i<n; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(visited[i][j] == false && arr[i][j] == 1) {
					cnt = 1;
//					System.out.println("dfs(" + i + ", " + j + ")");
					dfs(i, j);
					cntArr.add(cnt);
				}
			}
		}
		System.out.println(cntArr.size());
		Collections.sort(cntArr);
		for(int i=0; i<cntArr.size(); i++) {
			System.out.println(cntArr.get(i));
		}
	}
	
	static void dfs(int x, int y) {
		
		//시작 점은 visited 체크. 
		visited[x][y] = true;

		//(x, y)가 0이 아니면 탐색 시작. 위, 아래, 오른쪽 옆
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
//			System.out.println("nx: " + nx + " ny: " + ny);
			if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if(arr[nx][ny] == 1 && visited[nx][ny] == false) {
					cnt++;
//					System.out.println("dfs(" + nx + ", " + ny + ")");
					dfs(nx, ny);
				}
			}
			
		}		
		
	}
}
