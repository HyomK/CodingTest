package BOJ.`Graph Traversal`

import java.util.*

fun main(){
    _11403().solution()
}

class _11403 {
    val MAX= 999_999_999
    fun solution() = with(System.`in`.bufferedReader()){
        val N = readLine().toInt()
        val map = Array(N){IntArray(N){0} }
        var visited = BooleanArray(N){false}
        var dist = IntArray(N){MAX}
        val queue = LinkedList<Int>()
        val st = java.lang.StringBuilder()

        for(i in 0 until N){
            map[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
        }
        queue.add(0)

        while(queue.isNotEmpty()){
            val head = queue.poll()

            if(visited[head]) continue
            visited[head]=true

            for(vertex in map[head].indices){
                if(map[head][vertex]==1){
                    dist[vertex] = 1
                    queue.add(vertex)
                }
            }
        }


        for(d in dist){
            if(d!=MAX) st.append("$d ")
            else st.append("0 ")
        }
        println(st)

    }
}