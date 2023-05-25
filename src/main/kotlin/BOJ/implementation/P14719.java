package BOJ.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class P14719 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringTokenizer heights = new StringTokenizer(br.readLine()," ");
        int H = parseInt(st.nextToken());
        int W = parseInt(st.nextToken());

        boolean [][] map = new boolean [H][W];
        int [] arr = new int [W];

        for(int i = 0; i<W;i++){
            int height = parseInt(heights.nextToken());
            arr[i] = height;
        }

        int sum = 0;

        for(int i = 1; i< W-1; i++) {
            int left = 0;
            int right = 0;

            for(int j = 0; j < i ;j++){
                left = Math.max(left,arr[j]);
            }
            for(int j=i+1; j<W ;j++){
                right = Math.max(right,arr[j]);
            }

            if(arr[i]<left && arr[i]<right)
               sum += Math.min(left,right) -arr[i];

        }
        System.out.println(sum);
    }
}
