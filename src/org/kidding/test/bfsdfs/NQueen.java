package org.kidding.test.bfsdfs;

import java.util.Scanner;

public class NQueen {
	//dfs 심화
	//모든 경우를 탐색하지 않고, 조건에 만족하지 않으면 백트래킹
	
	//크기 설정
	private static int n;
	//퀸 위치. col[1] = 1 이면 1행의 1열에 위치. col[15] = 15면 15행 15열에 위치
	private static int[] pos;
	//가능 갯수
	private static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			//시작점 설정.
			pos = new int[16];
			//1부터 시작. (1,1)에 최초 퀸 배치. 
			//pos[1] = 2 는 1행의 2번째 열에퀸 배치. 
			pos[1] = i;
			//깊이우선탐색. 2행에 퀸이 어디 존재할 수 있는가로 시작.  
			dfs(2);
		}
		System.out.println(cnt);
	}
	
	static void dfs(int row) {
		// 행이 전체 체스판길이를 넘어가면 탐색 종료. 갯수 추가. 
		if(row > n) {
			++cnt;
		}else {
			// 탐색하는 행(row)의 i열에 체스를 두었을 때 가능하다면 다음행으로 넘어가서 탐색
			// 불가능하다면 해당 부분은 폐기(값=0)
			for(int i=1; i<=n; i++) {
				pos[row] = i;
				
				if(isPossible(row)) {
					dfs(row+1);
				}else {
					pos[row]=0;
				}	
			}
		}
	}
	
	static boolean isPossible(int col) {
		
		//이전 행에 놓인 퀸의 위치와 대각선 관계에 있거나, 같은 열에 있으면 X
		for(int i=1; i<col; i++) {
			//이전 행에 퀸이 놓여있을 때, 같은 열에 퀸이 놓여있을 순 없음.
			if(pos[i] == pos[col]) {
				return false;
			}
			//대각선 판단: 열 간 차이 == 행 간 차이
			if(Math.abs(pos[i]-pos[col]) == Math.abs(i-col)) {
				return false;
			}
		}
		return true;
	}
	
	
}
