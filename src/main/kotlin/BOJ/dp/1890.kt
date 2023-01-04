package BOJ.dp

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    _1890().solution()
}

class _1890{
    fun solution()=with(BufferedReader(InputStreamReader(System.`in`))){
        val n = readLine().toInt()
        val map = mutableListOf<IntArray>()
        val dp = Array(n){LongArray(n,{0})}
        val answer = 0L
        for(i in 0 until n){
            val row = readLine().split(" ").map{it.toInt()}
            map.add(row.toIntArray())
        }

        dp[map[0][0]][0]=1
        dp[0][map[0][0]]=1

        for(i in 0 until n){
            for(j in 0  until n){
                if(dp[i][j]>0 && map[i][j] !=0 ){
                    if(j+map[i][j] < n ){
                        dp[i][j+map[i][j]] = dp[i][j]+ dp[i][j+map[i][j]]
                    }
                    if(i+map[i][j]< n){
                        dp[i+map[i][j]][j]= dp[i][j]+ dp[i+map[i][j]][j]
                    }
                }
            }
        }
        println(dp[n-1][n-1])
    }
}