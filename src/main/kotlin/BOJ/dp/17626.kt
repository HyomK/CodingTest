package BOJ.dp

import BOJ.structure._1620
import MyBuffer
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.HashMap
import kotlin.math.min

fun main(){
    _17626().solution()
}

class _17626 {
    private val br = MyBuffer().br
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val dp = IntArray(50001,{0}) // 제곱수 개수를 저장한다
        var input = br.readLine().toInt()
        dp[0]=0
        dp[1]=1 // 1^2
        var min = 0
        for(i in 1..input){
            var j =1
            min = Int.MAX_VALUE
            while(j*j<=i){
                min = Math.min(min,dp[i-j*j]) // dp[5] 를 구한다면 dp[2^2] +1
                j++
            }
            dp[i]= min+1
        }
        println(dp[input])
    }
}