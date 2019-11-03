package org.kidding.test.dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RGBStreet {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //집 갯수
        int n = Integer.parseInt(br.readLine());
        int[][] house = new int[n][3];	//각 집 색칠 비용
        int[][] cost = new int[n][3]; 	//색칠 비용 최소 총합

        //집 갯수 만큼의 배열 생성 
        for(int i=0; i<n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<3; j++) {
            	house[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        //cost[0][] 셋팅
        for(int i=0; i<3; i++) {
        	cost[0][i] = house[0][i];
        }

        //현재 집까지의 최소 비용은?        
        for (int a=1; a<n; a++) {
	        cost[a][0] = house[a][0] + Math.min(cost[a-1][1], cost[a-1][2]);
	        cost[a][1] = house[a][1] + Math.min(cost[a-1][0], cost[a-1][2]);
	        cost[a][2] = house[a][2] + Math.min(cost[a-1][0], cost[a-1][1]);
        }
        
        int minCost = cost[n-1][0];
        for(int i=1; i<3; i++) {
        	if(minCost > cost[n-1][i]) {
        		minCost = cost[n-1][i];
        	}
        }
        
        sb.append(minCost);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
}
