package BOJ.structure

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.HashMap

fun main(){
    _14425().solution()
}

class _14425 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val input =readLine()!!.toString().split(" ").map{it.toInt()}
        val size = input[0]
        val test = input[1]
        val group = HashMap<String,Int>()
        var ans = 0

        for(i in 1..size){
            group[readLine().toString()] = i
        }

        for(i in 0 until test){
           if(group.getOrDefault(readLine().toString(),0)!=0){
               ans++
           }
        }
        bw.write("${ans}")
        bw.flush()
        bw.close()
    }

}