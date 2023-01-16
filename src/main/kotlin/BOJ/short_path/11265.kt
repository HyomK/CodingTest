package BOJ.short_path

import java.util.*

fun main(){
    _11265().solution()
}

class _11265 {
    data class Node(val node : Int, val weight : Int) : Comparable<Node>{
        override fun compareTo( otherNode : Node) : Int{
            return weight - otherNode.weight
        }
    }

    fun solution() = with(System.`in`.bufferedReader()){
        val MAX = 999_999_999
        val input = readLine().split(" ").map{it.toInt()}
        val N = input[0]
        val M = input[1]

        val dist = Array(N+1){ IntArray(N+1){MAX} }


        for(i in 1.. N){
            val times = readLine().split(" ").map{it.toInt()}.toIntArray()
            for(j in 1..N){
                dist[i][j] = times[j-1]
            }
        }



        for(k in 1..N){
            for(i in 1..N){
                for(j in 1..N){
                   dist[i][j] = Math.min(dist[i][k]+dist[k][j] , dist[i][j])
                }
            }

        }
        val answer = java.lang.StringBuilder()
        for(j in 0 until M){
            val case = StringTokenizer(readLine(), " ")
            val start = case.nextToken().toInt()
            val dest = case.nextToken().toInt()
            val endTime = case.nextToken().toInt()

            if(endTime >= dist[start][dest]) answer.append("Enjoy other party\n")
            else  answer.append("Stay here\n")
        }
        println(answer)
    }
}