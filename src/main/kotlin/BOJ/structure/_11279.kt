package BOJ.structure

import MyBuffer
import java.io.BufferedReader

import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(){
    _11279().solution()
}

class _11279 {
    val br =  BufferedReader(InputStreamReader(System.`in`))

    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val input =readLine().toInt()!!
        val heap = PriorityQueue<Int>(compareByDescending { it })

        for(k in 0 until input){
            val i = readLine().toInt()
            if(i==0){
                if(heap.isEmpty()){
                    bw.write("${0}"+'\n')
                    continue
                }
                bw.write("${heap.poll()}"+'\n')
            }
            else{
                 heap.add(i)
            }
        }
        bw.flush()
        bw.close()
    }

}