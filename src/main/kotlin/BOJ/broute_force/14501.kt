package BOJ.broute_force

import java.util.StringTokenizer
import kotlin.math.cos

fun main(){
    P14501().solution()
}

class P14501 {

    fun solution()=with(System.`in`.bufferedReader()){
        val N = readLine().toInt()
        val time = IntArray(N){0}
        val pay = IntArray(N){0}
        val dp = IntArray(N+1){0}

        for(i in 0 until N){
            val st = StringTokenizer(readLine()," ")
            val day= st.nextToken().toInt()
            val cost =  st.nextToken().toInt()
            time[i]=day
            pay[i]=cost
        }


        for(i in 0 until N){
            val next = i+time[i]
            //날짜가 범위를 넘어가지 않는 경우
            if(next<=N) {
                dp[next] = Math.max(dp[next] , dp[i]+pay[i])
            }
            dp[i+1] = Math.max(dp[i+1],dp[i])
        }

        println(dp[N])
    }
}