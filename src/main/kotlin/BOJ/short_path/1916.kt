package BOJ.short_path

import java.util.*

fun main(){
    _1916().solution()
}

class _1916 {
    val INF =1e9.toInt()

    data class Bus (val node : Int, val weight : Int) : Comparable<Bus>{
        override fun compareTo(other: Bus): Int {
            return weight - other.weight
        }
    }

    fun solution () = with(System.`in`.bufferedReader()){
        val N = readLine().toInt()
        val M = readLine().toInt()
        val dist = MutableList(N+1){MutableList<Bus>(N+1){Bus(-1,INF)}}
        val route =IntArray(N+1){INF}
        val queue = PriorityQueue<Bus>()
        val visited = BooleanArray(N+1){false}

        repeat(M){
            val input = StringTokenizer(readLine(), " ")
            val start = input.nextToken().toInt()
            val dest = input.nextToken().toInt()
            val weight = input.nextToken().toInt()
            dist[start][dest] =Bus(dest,  Math.min(dist[start][dest].weight, weight))
        }
        val st= StringTokenizer(readLine(), " ")
        val startPos = st.nextToken().toInt()
        val endPos = st.nextToken().toInt()

        //다익스트라 알고리즘
        queue.add(Bus(startPos,0))
        route[startPos]=0

        while (queue.isNotEmpty()){
            val cur = queue.poll()
            if(visited[cur.node]) continue
            visited[cur.node] = true

            for(vertex in dist[cur.node]){
                if(vertex.node == -1) continue
                val cost = route[cur.node] + vertex.weight
                if( !visited[vertex.node] && cost < route[vertex.node]){
                    route[vertex.node] = cost
                    queue.add(Bus(vertex.node,cost))
                }
            }
        }

        println(route[endPos])

    }
}