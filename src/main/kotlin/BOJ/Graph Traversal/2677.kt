package BOJ.`Graph Traversal`

import java.util.LinkedList
import java.util.Queue

fun main(){
    _2677().solution()
}

class _2677{
    val dx = listOf(1,0,-1,0)
    val dy = listOf(0,-1,0,1)
    var N = 0
    var count = 0
    var area = 0

    lateinit var map : Array<MutableList<Int>>
    lateinit var visited : Array<MutableList<Boolean>>
    var queue = mutableListOf<Pair<Int,Int>>()
    var answer = mutableListOf<Int>()
    fun solution() = with (System.`in`.bufferedReader()){
        N = readLine().toInt()
        map = Array(N){ mutableListOf()}
        visited = Array(N+1){Array(N+1){false}.toMutableList() }

        for(i in 0 until N){
            val input = readLine().toString()
            val list = mutableListOf<Int>()
            for(element in input){
                list.add(element - '0')
            }
            map[i] = list
        }

        for(i in 0 until N){
            for(j in 0 until N){
                if(!visited[i][j] && map[i][j]==1) {
                    area = 0
                    count++
                    dfs(i,j)
                    answer.add(area)
                }
            }
        }
        answer.sort()

        println(count)
        for(ans in answer){
            println(ans)
        }
    }

    fun dfs( row : Int , col : Int){
        if( !visited[row][col]&& map[row][col]==1) area++
        visited[row][col] = true

        for(i in 0 until 4){
            val nR = row + dy[i]
            val nC = col + dx[i]
            if(nR>=0 && nR<N && nC>=0 && nC<N){
               if( !visited[nR][nC] && map[nR][nC] == 1) dfs(nR,nC)
            }
        }
//
//        while(queue.isNotEmpty()){
//            val head = queue.first()
//            queue.removeAt(0)
//            if(!visited[head.first][head.second]) dfs(head.first,head.second)
//        }
    }
}