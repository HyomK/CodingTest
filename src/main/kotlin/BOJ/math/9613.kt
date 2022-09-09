package BOJ.math

import java.io.*

fun main(){
    val sol = _9613().solution()
}

class _9613 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val size = readLine()!!.toInt()
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        for( case in 0 until size ){
            val numbers = with(readLine().toString().split(" ")){
                return@with this.subList(1,this.size)
            }
            var sum = 0L
            numbers.forEachIndexed { index, s ->
                for ( i in index+1 until numbers.size ){
                    sum += getGCD(s.toInt(),numbers[i].toInt())
                }
            }
            println(sum)
        }
    }
    fun getGCD(x : Int , y: Int) : Long{
        if(y == 0) return x.toLong();
        else return getGCD(y,x % y);
    }
}
