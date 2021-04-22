package org.kidding.test.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Sudoku {
	
	//스도쿠 입력 필요 
	//가로 체크, 세로 체크, 3x3 박스 체크
	//(0,0)부터 탐색. 열 이동. 0이 아니면 pass. 0이면 가로, 세로, rec 탐색
	//탐색 기준은? 1~9까지 모두 넣어보기. 그래서 모두 true가 뜨면 ?
	//탐색 중 0을 마주치면 해당 부분에서 다시 탐색. 모두 true가 뜨면 ok하고 다시 탐색.
	//일단 이렇게 해보자 
	int[][] answer;
	
	public static void main(String[] args) throws IOException {

		//스도쿠판 생
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] sudoku = new int[8][8];
		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}
	
	public void dfs() {
		
	}
	
	public boolean checkCol() {
		return true;
	}
	
	public boolean checkRow() {
		return true;
	}
	
	public boolean checkRec() {
		return true;
	}

}
