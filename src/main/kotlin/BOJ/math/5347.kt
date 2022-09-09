package BOJ.math

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    _5347().solution()
}

class _5347 {

    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val size = readLine()!!.toInt()
        for ( i in 0 until size ){
            var numbers = readLine()!!.toString().split(" ").map{it->it.toLong()}
            println(getLCM(numbers[0],numbers[1]))
        }
    }

    fun getLCM (a : Long, b: Long) :Long{
        return a * b / getGCM(a,b)
    }

    fun getGCM (a : Long, b : Long):Long{
        return if(b == 0L) a
        else getGCM(b , a % b)
    }
}