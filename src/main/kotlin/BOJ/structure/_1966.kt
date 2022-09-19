package BOJ.structure

import MyBuffer
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Queue

fun main(){
    val sol = _1966().solution()
}

class _1966 {
    val br = MyBuffer().br
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val cases = br.readLine()!!.toInt()
        for( case in 0 until cases ){
            val st = br.readLine().toString().split(" ").map { it.toInt() }
            val queue = ArrayDeque<Pair<Int,Int>>()
            //index / weight
            br.readLine().toString()
                .split(" ")
                .mapIndexed { index, s -> queue.add( Pair(index,s.toInt())) }
            val pos  = queue[st[1]]
            var count =0
            loop@ while(queue.isNotEmpty()){
                val max = queue.map { it ->it.second }.maxOrNull()
                if(max==pos.second && queue[0].first==pos.first){
                    count++
                    queue.removeFirst()
                    break@loop
                }else if(max==queue[0].second){
                    count++
                    queue.removeFirst()
                }else{
                    queue.addLast(queue.first())
                    queue.removeFirst()
                }

            }
            println("${count}")
            queue.clear()

        }
    }


}
