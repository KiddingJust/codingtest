package org.kidding.test.stackandqueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Josephus {

	//조셉퍼스
	//7 3 -> 3 (1,2,4,5,6,7) , 6(1,2,4,5,7), 2(1,4,5,7), 7(1,4,5), 5(1,4), 
	//큐 활용, 계속해서 쌓아가면서 일정 갯수 출력하면 멈추기 
	// 1234567124571451414444
	public static void main(String[] args) throws IOException {
        
		//Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //Output
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        //전체 수
        int total = Integer.parseInt(st.nextToken());
        //삭제할 순서
        int order = Integer.parseInt(st.nextToken());
        //탐색 노드
        int cnt = 0;
        //출력 수
        int outputCnt = 0;
        
        Queue<Integer> que = new LinkedList<>();
        
        for(int i=0; i<total; i++) {
        	que.add(i+1);
        }
        
        while(outputCnt < total) {
        	//탐색 시작
        	int pollNum = que.poll();
        	//노드 ++
        	cnt++;
        	if(cnt == order) {
        		sb.append(pollNum + ", ");
        		outputCnt++;
        		cnt = 0; //탐색 노드 초기
        	}else {
        		//queue에 추가 
        		que.add(pollNum);
        	}
        }
        
        sb.delete(sb.length()-2, sb.length());   // 마지막 ", " 제거 
        sb.append(">");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
         
	}
}
