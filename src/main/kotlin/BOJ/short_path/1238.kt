package BOJ.short_path

import java.util.*

fun main(){
    _1238().solution()
}
data class Node(val node : Int, val weight : Int):Comparable<Node>{
    override fun compareTo(other: Node): Int {
        return weight - other.weight
    }
}


class _1238() {
    val INF : Int = 1e9.toInt()
    lateinit var dist : MutableList<MutableList<Node>>

    var N = 0

    fun dijksta(start : Int , end : Int) : Int{
        val route = MutableList(N+1){INF}
        val queue = PriorityQueue<Node>()
        val visited = BooleanArray(N+1){false}
        queue.add(Node(start,0))
        route[start]=0

        while (queue.isNotEmpty()){
            val cur = queue.poll()
            if(visited[cur.node]) continue
            visited[cur.node] = true

            for(edge in dist[cur.node]){
                if(visited[edge.node]) continue
                if(route[edge.node]> route[cur.node]+edge.weight){
                    route[edge.node] = route[cur.node]+edge.weight
                    queue.add(Node(edge.node,route[edge.node]))
                }
            }
        }
        return route[end]
    }

    fun solution() = with(System.`in`.bufferedReader()){
        //오는 값과 가는 값을 더해야한다
        //모든 지점에서 하나의 지점으로 가는 길을 구하는 문제
        //플로이드 워셜
        val st = StringTokenizer(readLine()," ")
        N = st.nextToken().toInt()
        val M = st.nextToken().toInt()
        val X = st.nextToken().toInt()

        dist  = MutableList(N+1,{Vector<Node>()})


        var go = MutableList(N+1){INF}
        val back = MutableList(N+1){INF}


        repeat(M){
            val st =  StringTokenizer(readLine()," ")
            val start = st.nextToken().toInt()
            val end = st.nextToken().toInt()
            val time = st.nextToken().toInt()

            dist[start].add(Node(end,time))
        }

        var max = 0

        for(start in 1..N){
            val result = dijksta(start,X)+dijksta(X,start)
            //println(result)
            if(result < INF) max = Math.max(result, max)
        }
        println(max)
    }
}
