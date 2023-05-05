package BOJ.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class P20207 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    static Boolean[][] cal = new Boolean[1001][367];
    static int[] map = new int[366];

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int max = 0;
        int min = 366;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = parseInt(st.nextToken());
            int end = parseInt(st.nextToken());
            for(int j = start ; j<=end ; j++){
                map[j]++;
            }

            max = Math.max(max, end); // 최대 길이
            min = Math.min(min,start);
        }

        int length = 0;
        int height = 0;

        for(int i=0; i<= 365 ; i++){
            if(map[i]==0 ){
                sum += length*height;
                length = 0;
                height = 0;
            }else{
                length++;
                height = Math.max(height,map[i]);
            }

        }
        sum += length*height;
        System.out.println(sum);
    }
}