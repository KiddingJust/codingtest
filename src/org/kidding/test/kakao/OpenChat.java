package org.kidding.test.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OpenChat {

	public static void main(String[] args) {
		
				
		//정보가 담긴 것. 
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		
		//정보를 담을 맵 
		Map<String, String> nickMap = new HashMap<>();	
		
		//뒤부터 탐색. 
		for(int i=record.length-1; i>=0; i-- ) {
			String[] temp = record[i].split(" ");
			//아직 uid와 닉네임이 맵핑되지 않았으며, LEAVE 제외 Enter, Change인 경우 nickMap에 담아줌. 
			if(nickMap.get(temp[1]) == null && temp.length >= 3) {
				nickMap.put(temp[1], temp[2]);
			}
		} 
		
		
		ArrayList<String> answer = new ArrayList<>();
		for(int i=0; i<record.length; i++) {
			String[] temp = record[i].split(" ");
			if(temp[0].equals("Enter")) {
				answer.add('"'+nickMap.get(temp[1])+"님이 들어왔습니다." + '"');
			}else if(temp[0].equals("Leave")) {
				answer.add('"'+nickMap.get(temp[1])+"님이 나갔습니다." + '"');
			}
		}
	
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}
		
		
		
	}
}
