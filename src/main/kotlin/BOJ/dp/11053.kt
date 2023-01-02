package BOJ.dp

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    _11053().solution()
}

class _11053{
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val n = readLine().toInt()
        val list = readLine().split(" ").map{it -> it.toInt()}
        val dp = IntArray(n,{1})
        var result =1;
        for(i in 0 until n){
            // j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우0
            for( j in 0 until i){
                if(list[j]<list[i] && dp[i]< dp[j]+1){
                    dp[i] = dp[j] + 1;
                }
            }

          result = Math.max(result,dp[i]);
        }
        print(result)
    }
}