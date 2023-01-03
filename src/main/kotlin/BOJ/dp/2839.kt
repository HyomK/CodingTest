package BOJ.dp

import java.io.BufferedReader
import java.io.InputStreamReader


fun main(){
    _2839().solution()
}

class _2839 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val n = readLine().toInt()
        val dp = IntArray(n+1){-1}
        for(i in 3..n){
            if(i%3==0) dp[i] = i/3
            if(i%5==0) dp[i] = i/5
            if(i>5 && dp[i-3]!= -1 && dp[i-5]!=-1)
                dp[i] = Math.min(dp[i-3]+1,dp[i-5]+1)
        }
        println(dp[n])
    }
}