package BOJ.dp

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    _1463().solution()
}


class _1463 {
    val dp = LongArray(1000001){0}
    fun solution () = with(BufferedReader(InputStreamReader(System.`in`))){
        /*bottom up*/
        var input = readLine().toLong();
        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
        dp[3]=1

        for(n in 4..input){
            dp[n.toInt()]= dp[(n-1).toInt()]+1;
            if(n%3L===0L){
                val divisionBy3 = dp[(n/3L).toInt()]+1;
                val minus1 = dp[n.toInt()]
                dp[n.toInt()]= Math.min(divisionBy3 ,minus1);
            }
            if(n%2L===0L){
                val divisionBy2 = dp[(n/2L).toInt()]+1;
                val minus1 = dp[n.toInt()]
                dp[n.toInt()]= Math.min(divisionBy2 ,minus1);
            }
        }
        print(dp[input.toInt()])
    }
}