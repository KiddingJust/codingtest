package org.kidding.test.kakao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FailureRatio {

	public static void main(String[] args) {
		
		//셋팅
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int c = sc.nextInt();
		int[] stages = new int[c];
		
		for(int i=0; i<stages.length; i++) {
			stages[i] = sc.nextInt();
		}
		//셋팅 완료
		
		// 특정 스테이지에 머물고 있는 인원 수를 a라 하면 a/(이후 스테이지 모든 인원 합 + a)
		// 5 , [2,1,2,6,2,4,3,3] -> 1/8, 3/7, 2/4, 1/2, 0/1
		
		
		int stage = 0;		//각 스테이지에있는 유저 수 찾는 기준. 
		double number = stages.length; 	// 각 스테이지에 잇는 유저 수
		double[][] rate = new double[N][2];	// 스테이지 & 실패율 담기
			
		while(stage < N) {

			double failure = 0;				// 스테이지에서 실패한 인원

			for(int i=0; i<stages.length; i++) {
				if(stage+1 == stages[i]) {
					failure++;
				}
				System.out.println("stage: " + (stage+1) + "failure: " + failure);
			}//for end
			
			rate[stage][0] = stage+1;
			rate[stage][1] = failure/number;
			
			//(예외처리) number가 0이 되면, 다음부터는 도전하는 사람이 없는 것(스테이지 도달 X -> 실패율:0) 
			if (number==0) {
				rate[stage][1] = 0;
			}
			number = number - failure;	//스테이지에 머물고 있는 사람은 다음 스테이지에서는 세지 않음.
			
			stage++;			
		}

		//정렬 
        Arrays.sort(rate, new Comparator<double[]>() {
            @Override
            public int compare(double[] x, double[] y) {
            	//x좌표 같으면 y좌표로 비
                if (x[1] == y[1]) {
                    return Double.compare(x[0], y[0]);
                }
                //기본은 x좌표로 비
                return Double.compare(x[1], y[1])*-1;
            }
 
        });
        
        int[] answer = new int[5];
        
		for(int i=0; i<rate.length; i++) {
			answer[i] = (int)rate[i][0];
			System.out.println(answer[i]);
			
		}
	}
}

