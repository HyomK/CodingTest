package BOJ.structure

import MyBuffer
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(){
    _20175().solution()
}

class _20175 {
    val br =  MyBuffer().br
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val input =readLine().toLong()!!
        val heap = PriorityQueue<Long>(compareByDescending { it })
        for(k in 0L until input){
            val arr : List<Long> = readLine().toString().split(" ").map{it.toLong()}
            for(j in 0 until input.toInt()){
                heap.add(arr.get(j))
            }
        }
        for(i in 1..input){
            if(i==input)bw.write(heap.peek().toString())
            heap.poll()
        }
        bw.flush()
        bw.close()
    }
}