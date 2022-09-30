package BOJ.dp

import MyBuffer
import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    _1010().solution()
}

class _1010 {
    fun solution()= with(BufferedReader(InputStreamReader(System.`in`))){
        val case = readLine().toInt()
        repeat(case){
            val dp = Array(31){LongArray(31)}
            val input = readLine().toString().split(" ")
            val r = input[0].toInt()
            var n = input[1].toInt()
            //mCn 공식을 이용
            for( i in 1..30){
                dp[i][1] = i.toLong()
            }
            for(i in 1.. 30){
                for(j in 2 ..30){
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j]
                }
            }
            println(dp[n][r])
        }
    }
}