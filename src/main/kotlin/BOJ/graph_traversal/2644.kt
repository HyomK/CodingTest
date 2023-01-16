package BOJ.graph_traversal

import java.util.LinkedList

fun main(){
    _2644().solution()
}

class _2644{
    var num = 0
    lateinit var people : Array<MutableList<Int>>
    lateinit var visited : BooleanArray
    var queue = LinkedList<Int>()
    var target1 = 0
    var target2 = 0
    var res = -1

    fun dfs(start : Int, end : Int , cnt : Int){
        if(start==end){
            res = cnt
            return
        }
        visited[start]= true
        for(vertex in people[start]){
            if(!visited[vertex]){
                dfs(vertex, end,cnt+1)
            }
        }
    }

    fun bfs(start : Int) : Int{
        var result = 0
        queue.add(start)

        while(queue.isNotEmpty()){
            val size = queue.size
            for(i in 0 until size){
                val cur = queue.poll()
                visited[cur] =true
                if(cur==target2) return result
                for(vertex in people[cur]){
                    if(!visited[vertex]) queue.add(vertex)
                }
            }
            result++
        }
        return -1
    }

    fun solution()=with(System.`in`.bufferedReader()){
        num = readLine().toInt()
        val input = readLine().split(" ").map{it.toInt()}
        val line = readLine().toInt()

        target1 = input[0]
        target2 = input[1]

        people = Array(num+1){ mutableListOf()}
        visited = BooleanArray(num+1){false}

        repeat(line){
            val input = readLine().split(" ").map{it.toInt()}
            people[input[0]].add(input[1])
            people[input[1]].add(input[0])
        }

        //dfs(target1, target2,0)
        println(res)
        println(bfs(target1))
    }
}