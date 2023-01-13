package BOJ.`Graph Traversal`

import java.util.*


fun main(){
    _14940().solution()
}

class _14940{
    var N = 0
    var M = 0
    lateinit var map : Array<IntArray>
    lateinit var visited :  Array<IntArray>

    val dx = listOf(-1,1,0,0)
    val dy = listOf(0,0,-1,1)

    var startX=0
    var startY=0

    fun solution()=with(System.`in`.bufferedReader()){
        var input = readLine().split( " ").map{it.toInt()}
        N = input[0]
        M = input[1]
        map = Array(N){ IntArray(M,{0}) }
        visited = Array(N){IntArray(M,{0})}

        val queue  = ArrayDeque<Pair<Int,Int>>()

        for(i in 0 until N){
            val list =IntArray(M,{0})
            val br = readLine()
            br.split(" ").forEachIndexed{ index, it->run{
               if(it=="2"){
                   startX = index
                   startY = i
               }
               map[i][index]=it.toInt()
            }}
        }

        queue.add(Pair(startY,startX))

        while(queue.isNotEmpty()){
            val head = queue.poll()
            println(head)
            for ( i in 0 until 4){
                val nR = head.first + dy[i]
                val nC = head.second+ dx[i]
                if(nR <0 || nR>=N || nC < 0 || nC>=M || map[nR][nC]==0 ||visited[nR][nC]!=0 ) continue
                visited[nR][nC]=visited[head.first][head.second]+1
                queue.add(Pair(nR,nC))
            }
        }
        visited[startY][startX]=0
        var answer = java.lang.StringBuilder()
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (map[i][j] == 0) answer.append("0 ")
                else answer.append("${visited[i][j]} ")
            }
            answer.append("\n")
        }
        println(answer)
    }

}