package BOJ.math

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val sol =_1978().solution()
    println(sol)
}

class _1978 {
    fun solution(): Int = with(BufferedReader(InputStreamReader(System.`in`))){
        var answer: Int = 0
        val size = readLine()!!.toInt()
        var numbers = readLine()!!.toString().split(" ")
        for( num in numbers ){
            var divisor = 0
            for (i in 2 until num.toInt()){
                if(num.toInt() % i == 0) divisor++
            }
            if(num.toInt() != 1 && divisor==0) answer++
        }
        return answer
    }
}