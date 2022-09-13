package BOJ.math

import MyBuffer
import java.io.*
import kotlin.math.sqrt

fun main(){
    val sol = _1747().solution()
}

class _1747 {
    private val br = MyBuffer().br

    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        var num = br.readLine().toInt()
        while (true) {
            if(isPrime(num)){
                val str = num.toString()
                if(str == str.reversed()){
                    println(str)
                    return@with
                }
            }
            num++
        }

    }

    fun isPrime(num : Int) : Boolean{
        if(num == 1) return false
        if(num == 2) return true
        for (i in 2 until sqrt(num.toDouble()).toInt()+1){
            if( num % i == 0 ) return false
        }
        return true
    }

}