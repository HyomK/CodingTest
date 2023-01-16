package BOJ.graph_traversal

import java.util.*

fun main(){
    _2606().solution()
}

class _2606{
    lateinit var computers  : Array<MutableList<Int>>
    lateinit var visited : BooleanArray
    val stack = Stack<Int>()
    var count = 0

    fun dfs (index : Int){
        visited[index]=true
        //println("index : $index")
        if(index!=1) count++
        for( next in computers[index] ){
           if(!visited[next]){
               dfs(next)
           }
        }
    }


    fun solution()=with(System.`in`.bufferedReader()){
        val num = readLine().toInt()
        val line = readLine().toInt()

        computers = Array(num+1) { mutableListOf<Int>() }
        visited = BooleanArray(num+1){false}
        visited[0]=true
        repeat(line){
            val input = readLine().split(" ").map{it.toInt()}
            val n = input[0]
            val m = input[1]
            computers[n].add(m)
            computers[m].add(n)
        }

        dfs(1)
        println(count)

    }
}