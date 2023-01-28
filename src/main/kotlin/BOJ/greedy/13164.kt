package BOJ.greedy

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.StringTokenizer
import kotlin.time.Duration.Companion.seconds

fun main(){
    P13164().solution()
}

class P13164 {
    fun solution() = with(System.`in`.bufferedReader()){
        val st = StringTokenizer(readLine() , " ")
        val N = st.nextToken().toInt()
        val total = st.nextToken().toInt()
        val group  = readLine().split(" ").map{it.toLong()}.toMutableList()
        val gap = LongArray(N-1){0}
        for(i in 0 until group.size-1){
            gap[i]=(group[i+1]-group[i])
        }
        gap.sort()
        var result = 0L

        for(j in 0 until N-total){
            result+=gap[j]
        }
        println(result)

    }
}