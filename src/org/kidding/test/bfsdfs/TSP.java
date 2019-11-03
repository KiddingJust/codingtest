package org.kidding.test.bfsdfs;
    
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
    
public class TSP {
    
    //외판원 순회: 한 도시에서 시작해 N개의 모든 도시를 거쳐 다시 원래 도시로 가는 것. 
    //W[i][j] : i -> j 로 가는 비용. 
    //기본적으로 순열을 따른다. 이미 간 도시는 갈 수 없으므로, 
    //N개의 도시를 가는 모든 경우의 수는 N!. 비용 계산을 N이라 할 때 시간 복잡도는 O(N*N!)
    // --> 1234 4321 1324, 4213 등등 모든 경우의 수를 해보아도 됨. 
    //1234, 2341, 3412, 4123 은 모두 같은 경우 (1->2->3->4->1) 
    // --> 고로 시작점을 1로 고정해도 된다. 
    static int n;
    static int[][] permu;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        permu = new int[n][n];
          
        //a b
        //c d 
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
         	    permu[i][j] = Integer.parseInt(st.nextToken());
            }
        }
           
        //1~N까지의 숫자를 담을 배열. 1부터 시작하는 경우를 가정했으니 n-1개. 
        int [] node = new int[n-1];
         
        //0번으로 이동하는 것을 제외한 이동값 초기화
        //node == {1, 2, ~ , n-2, n-1}
        for(int i=0; i<n-1; i++) {
            node[i] = i+1;
        }    
        
        int cost = Integer.MAX_VALUE;
        
        do {
            //갈 수 있는 도시 체크. 
            boolean go = true;
            int sum = 0;
            //i-1 크기의 배열이므로 i-2 인덱스까지 존재. 
            //갈 수 없는 도시면 false, 갈 수 있는 도시면 금액 합에 추가(sum)
            for (int i=0; i<n-2; i++) { 
            	// permu[a][b] == 0 이면 갈 수 없는 도시.
                if (permu[node[i]][node[i+1]] == 0) {
                    go = false;
                } else {
                    sum += permu[node[i]][node[i+1]];
                }
            }
            //못가는 도시가 없었고
            //0번째 도시에서 첫 번째 도시로 갈때 0이 아니고
            //마지막 도시에서 0번째 도시로 갈때 0이 아니면
            if (go && permu[0][node[0]] != 0 && permu[node[n-2]][0] != 0) { 
            	//0번 첫 번째로 가는 비용 + 마지막에서 0번째로 가는 비용
                sum += permu[0][node[0]] + permu[node[n-2]][0]; 
                //최소 비용 구하기. 
                if (cost > sum) {
                    cost = sum;
                }
            }
        } while(nextPermutation(node));
        
        sb.append(cost);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
	
    static void swap(int [] permu, int i, int j) {
        int temp = permu[i];
        permu[i] = permu[j];
        permu[j] = temp;
    }
    
    public static boolean nextPermutation(int [] permu) {
        int i = permu.length-1;
        while(i > 0 && permu[i] <= permu[i-1])
            i--;
 
        if(i<=0)
            return false;
 
        int j = permu.length-1;
        while(permu[j] <= permu[i-1]) {
            j--;
        }
 
        swap(permu, i-1, j);
 
        j = permu.length-1;
        while(i < j) {
            swap(permu, i, j);
            i++;
            j--;
        }
        return true;
    }	

}
