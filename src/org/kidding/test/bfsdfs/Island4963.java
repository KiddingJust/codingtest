package org.kidding.test.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//단순 가로세로 연결이 아닌 대각선 연결까지 고려해야 하는 케이스
//깊이우선 탐색으로 하는 편이 나을듯 
//갔는데 없으면 돌아오는 게 깊이우선 탐
public class Island4963 {
	
	static int[][] arr;
	static boolean[][] visited;
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static int hor; 
	static int ver;
	static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
	static int[] dy = {0, 0, 1, -1, 1, 1, -1, -1};
	static int num;
	static ArrayList<Integer> answer = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
		//반복문으로 처리되어야 함. horizon, vertical 헷갈리지 X 
		String[] temp = br.readLine().split(" ");
		ver = stoi(temp[0]);
		hor = stoi(temp[1]);
		
		if (hor == 0 && ver == 0) {
			break;
		}
		
		arr = new int[hor][ver];
		visited = new boolean[hor][ver];
		
		for(int i=0; i<hor; i++) {
			String[] tempArr = br.readLine().split(" ");
			for (int j=0; j<ver; j++) {
				arr[i][j] = stoi(tempArr[j]);
			}
		}
		
//		for(int i=0; i<hor; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

		for(int i=0; i<hor; i++) {
			for(int j=0; j<ver; j++) {
				if(visited[i][j] == false && arr[i][j] == 1) {
//				    System.out.println("dfs(" + i + ", " + j + ")");
					dfs(i, j);
					num ++;
				}
			}
		}
		answer.add(num);
		num = 0;
		}
		
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		};
	}
	
	static void dfs(int x, int y) {
		
		//방문했으니 일단 true로 변경
		visited[x][y] = true;
		
		for(int n=0; n<8; n++) {
			int nx = x + dx[n];
			int ny = y + dy[n];
			if(nx >= 0 && ny >=0 && nx < hor && ny < ver) {
				if(arr[nx][ny] == 1 && visited[nx][ny] == false) {
					dfs(nx, ny);
				}
			}
		}
	}
}
