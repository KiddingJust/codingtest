package org.kidding.backjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EscapeMarble {

	//�씪�떒 吏�湲덉쿂�읆 ��硫� �솕�뜕 寃쎈줈瑜� �릺�룎�븘媛��뒗 寃쎌슦媛� �깮源�. visited[] 瑜� �빐二쇱뼱�빞 �븿. 
	//�씠�쟾�뿉 ���뿀�뜕  bfs, dfs 癒쇱� �떎�떆 ���뼱蹂닿퀬 �씠 臾몄젣 �젒洹쇰쾿 �떎�떆 �씡�엳湲�. 
	//�븳踰덉뿉 ��吏곸씠�뒗 嫄� �깮媛곹빐�빞�븯�굹.. 彛� �씠�룞�븷嫄대뜲 以묎컙�뿉 0 �엳�쑝硫� -1濡� �빐二쇨린. 
	// --> 洹몃━怨� dfs �떆�뿉 �몮�떎 -1�씠硫� �걹! �몮以� �븯�굹媛� -1�씠硫� �뀋�뀑 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		String[][] arr = new String[x][y];
		int[][] placeX = new int[3][2];
		int[][] placeY = new int[3][2];

		System.out.println(arr.length + " " +  arr[0].length);
		int depth = 0;
		
		//怨듬갚�뾾�씠 �옒�씪�꽌 �벝 �븧 洹몃깷 split �븯�뒗 寃� 留덉쓬 �렪�븿. 
		for(int i=0; i<x; i++) {
			String[] temp = br.readLine().split("");
			for(int j=0; j<y; j++) {
				if(temp[j].equals("R")) {
					arr[i][j] = temp[j];
					placeX[0][0] = i;
					placeX[0][1] = j;
					placeY[0][0] = i;
					placeY[0][1] = j;
				}else if(temp[j].equals("B")) {
					arr[i][j] = temp[j];
					placeX[1][0] = i;
					placeX[1][1] = j;
					placeY[1][0] = i;
					placeY[1][1] = j;
				}else if(temp[j].equals("O")) {
					arr[i][j] = temp[j];
					placeX[2][0] = i;
					placeX[2][1] = j;
					placeY[2][0] = i;
					placeY[2][1] = j;
				}else {
					arr[i][j] = temp[j];
				}
			}
		}
		
		System.out.println("place[0][0]: " + placeX[0][0]);
		System.out.println("place[0][1]: " + placeX[0][1]);
		System.out.println("place[1][0]: " + placeX[1][0]);
		System.out.println("place[1][1]: " + placeX[1][1]);
		
		//dfs �븿�닔 怨좉퀬. B, R, 0 �쐞移� �떞�� 諛곗뿴, depth
		int answer = dfs(arr, placeX, depth, "x");
		
		System.out.println(" ################################");
		System.out.println("place[0][0]: " + placeY[0][0]);
		System.out.println("place[0][1]: " + placeY[0][1]);
		System.out.println("place[1][0]: " + placeY[1][0]);
		System.out.println("place[1][1]: " + placeY[1][1]);		
		int answer2 = dfs(arr, placeY, depth, "y");
		
		System.out.println("answer: " + answer);
		System.out.println("answer2: " + answer2);
	}
	
	static int dfs(String[][] arr, int[][] place, int depth, String direction) {
		
		System.out.println("dfs(" + depth + ", " + direction + ")");
		System.out.println("place[0][0]: " + place[0][0]);
		System.out.println("place[0][1]: " + place[0][1]);
		System.out.println("place[1][0]: " + place[1][0]);
		System.out.println("place[1][1]: " + place[1][1]);
		System.out.println("========================================");
		if(place[0][0] == -1 || place[0][1] == -1) {
			System.out.println("여기안오나??");
			if(place[1][0] != -1 && place[1][1] != -1) {
				return depth;
			}else {
				return -1; 
			}
		}
		if(place[1][0] == -1 || place[1][1] == -1) {
			return -1;
		}
		if(depth > 10) {
			return -1;
		}
		
		if(direction.equals("x")) {
			//�븘�옒履� �씠�룞(x)
			if(arr[place[0][0]+1][place[0][1]].equals(".") || arr[place[0][0]+1][place[0][1]].equals("O") || arr[place[0][0]+1][place[0][1]].equals("B")) {
				//�뿴�씠 媛숆퀬, B媛� �뜑 �븘�옒履쎌뿉 �엳�쓣 �븣(B媛� 癒쇱� �씠�룞�븷 �븣)
				if(place[0][1] == place[1][1] && place[0][0] < place[1][0]) {
					System.out.println("X + -->  B 이동하고   R 이동 ");
					place[1][0] = move(arr, place[1][0], place[0][1], "x+");
					place[0][0] = move(arr, place[0][0], place[0][1], "x+");
					dfs(arr, place, depth+1, "y");
				}else {								//�뿴 �떎瑜� �븣
					System.out.println("X + -->  R 이동하고   B 이동 ");
					place[0][0] = move(arr, place[0][0], place[0][1], "x+");
					place[1][0] = move(arr, place[1][0], place[0][1], "x+");	
					dfs(arr, place, depth+1, "y");
				}	
			};
			//�쐞履� (x)
			if(arr[place[0][0]-1][place[0][1]].equals(".") || arr[place[0][0]-1][place[0][1]].equals("O") || arr[place[0][0]-1][place[0][1]].equals("B")) {
				//�뿴�씠 媛숆퀬, B媛� �뜑 �쐞履쎌뿉 �엳�쓣 �븣(B媛� 癒쇱� �씠�룞)
				if(place[0][1] == place[1][1] && place[0][0] > place[1][0]) {
					System.out.println("X - -->  B 이동하고   R 이동 ");
					place[1][0] = move(arr, place[1][0], place[0][1], "x-");
					place[0][0] = move(arr, place[0][0], place[0][1], "x-");
					dfs(arr, place, depth+1, "y");
				}else {								//�뿴 �떎瑜� �븣
					System.out.println("X - -->  R 이동하고   B 이동 ");
					place[0][0] = move(arr, place[0][0], place[0][1], "x-");
					place[1][0] = move(arr, place[1][0], place[0][1], "x-");	
					dfs(arr, place, depth+1, "y");
				}				
			};			
		}else {
			// �삤瑜몄そ (y)
			if(arr[place[0][0]][place[0][1]+1].equals(".") || arr[place[0][0]][place[0][1]+1].equals("O") || arr[place[0][0]][place[0][1]+1].equals("B")) {
				//�뻾�씠 媛숆퀬 B媛� �뜑 �삤瑜몄そ�뿉 �엳�쓣 �븣(B媛� 癒쇱� �씠�룞)
				if(place[0][0] == place[1][0] && place[0][1] < place[1][1]) {	//�뻾�씠 媛숈쓣 �븣
					System.out.println("Y + -->  B 이동하고   R 이동 ");
					place[1][1] = move(arr, place[0][0], place[1][1], "y+");
					place[0][1] = move(arr, place[0][0], place[0][1], "y+");
					dfs(arr, place, depth+1, "x");
				}else {								//�뻾 �떎瑜� �븣
					System.out.println("Y + -->  R 이동하고   B 이동 ");
					place[0][1] = move(arr, place[0][0], place[0][1], "y+");
					place[1][1] = move(arr, place[0][0], place[1][1], "y+");
					dfs(arr, place, depth+1, "x");				
				}			
			};
			System.out.println("아 여기를 또타는구나 이전 메서드에서 ");
			// �쇊履� (y)
			if(arr[place[0][0]][place[0][1]-1].equals(".") || arr[place[0][0]][place[0][1]-1].equals("O") || arr[place[0][0]][place[0][1]-1].equals("B")) {
				//�뻾�씠 媛숆퀬, B媛� �뜑 �쇊履쎌뿉 �엳�쓣 �븣(B媛� 癒쇱� �씠�룞)
				if(place[0][0] == place[1][0] && place[0][1] > place[1][1]) {	//�뻾�씠 媛숈쓣 �븣
					if(place[0][0] == place[1][0] && place[0][1] < place[1][1]) {	//�뻾�씠 媛숈쓣 �븣
						System.out.println("Y - -->  B 이동하고   R 이동 ");
						place[1][1] = move(arr, place[0][0], place[1][1], "y-");
						place[0][1] = move(arr, place[0][0], place[0][1], "y-");
						dfs(arr, place, depth+1, "x");
					}else {								//�뻾 �떎瑜� �븣
						System.out.println("Y - -->  R 이동하고   B 이동 ");
						place[0][1] = move(arr, place[0][0], place[0][1], "y-");
						place[1][1] = move(arr, place[0][0], place[1][1], "y-");
						dfs(arr, place, depth+1, "x");				
					}						
				}		
			};	//�쇊履� (y)			
		}

		return -1;
	}
	
	static int move(String[][] arr, int x, int y, String xy) {
		System.out.println("move( " + x + ", " + y + ", " + xy + ")");
		int ret = 0;
		
		if(xy.equals("x+")) {						//�븘�옒濡� �씠�룞�븷 �븣 				
			while(x<arr.length-1) {
				if(arr[x+1][y].equals(".")) {
					x++;
					ret = x;
				}else if(arr[x+1][y].equals("O")) {
					ret = -1;
					break;
				}else {
					return x;
				}
			}
		}else if(xy.equals("x-")){
			while(x>-1) {
				if(arr[x-1][y].equals(".")) {
					x--;
					ret = x;
				}else if(arr[x-1][y].equals("O")) {
					ret = -1;
					break;
				}else {
					return x;
				}
			}			
		}else if(xy.equals("y+")) {
			while(y<arr[0].length-1) {
				if(arr[x][y+1].equals(".")) {
					y++;
					ret = y;
				}else if(arr[x][y+1].equals("O")) {
					ret = -1;
					break;
				}else {
					return y;
				}
			}
		}else {
			while(y>-1) {
				if(arr[x][y-1].equals(".")) {
					y--;
					ret = y;
				}else if(arr[x][y-1].equals("O")) {
					ret = -1;
					break;
				}else {
					return y;
				}
			}				
		}
		
		return ret;
	}
	
	void isEmpty(int[][] arr) {
		
	}
	
}
