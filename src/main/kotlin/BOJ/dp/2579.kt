package BOJ.dp

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    _2579().solution()
}

class _2579(){
    fun solution ()= with(BufferedReader(InputStreamReader(System.`in`))){
        val n = readLine().toInt()
        val stair = mutableListOf<Int>()
        val dp = IntArray(n+1,{0})

        stair.add(0)
        repeat(n){
            stair.add(readLine().toInt())
        }

        dp[0]=0
        dp[1]=stair[1]

        /* 계단을 밟는 방법
        * 1. 직전 계단을 밟고 온다 dp[i-2]+stair[i-1]+stair[i] -> 1 - 3 - 4
        * 2. 2개 전의 계단을 밟고 온다 dp[i-2]+stair[i] -> 1 - 2 - 4
        * */
        for(i in 2..n){
           if(i == 2) dp[2]=stair[1]+stair[2]
           else if(i == 3) dp[3]=Math.max((stair[1]+stair[3]),stair[2]+stair[3])
           else dp[i] = Math.max(( dp[i-3]+ stair[i-1]+stair[i] ),( dp[i-2]+stair[i] ))
        }
        println(dp[n])
    }
}