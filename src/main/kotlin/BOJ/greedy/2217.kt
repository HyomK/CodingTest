package BOJ.greedy

import java.util.LinkedList

fun main(){
    P2217().solution()
}



class P2217 {
    fun solution()=with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val rope = IntArray(N){0}
        repeat(N){
            rope[it] = readLine().toInt()
        }
        rope.sort()
        rope.reverse()
        var min = 0

        println(rope.contentToString())
        for(i in 1..rope.size){
            min = Math.max(min,rope[i-1]*i)
        }
        println(min)

    }
}