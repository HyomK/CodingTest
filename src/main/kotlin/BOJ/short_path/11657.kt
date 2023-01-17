package BOJ.short_path

import java.util.*

fun main(){
    _11657().solution()
}
data class Edge(val from: Int, val to: Int, var cost: Long)
class _11657 {
    var N = 0
    var M = 0
    val MAX : Long = 987654321

    var graph = Vector<Edge>()
    lateinit var dist : LongArray

    fun bellmanFord ( start :Int) : Boolean{
        dist[start] = 0

        for(j in 1 until N){
            for(k in 0 until M){
                val cur = graph.get(k)
                if(dist[cur.from]!=MAX ){
                    val cost = dist[cur.from] + cur.cost
                    if( cost < dist[cur.to] ){
                        dist[cur.to] = cost
                    }
                }
            }
        }

        //음수 가중치 확인
        for (j in 0 until M){
            //현재 간선의 들어오는 정점에 대해 비교 -> 더 작은 값 생기면 음수 사이클 존재
            val cur = graph.get(j)
            if(dist[cur.from]!= MAX && dist[cur.to] > dist[cur.from] +cur.cost){
                return true
            }
        }
        return false
    }

    fun solution () = with(System.`in`.bufferedReader()){

        val st = StringTokenizer(readLine()," ")
        N = st.nextToken().toInt()
        M = st.nextToken().toInt()

        dist = LongArray(N+1){MAX}
        repeat(M){
            val case = StringTokenizer(readLine(), " ")
            val start = case.nextToken().toInt()
            val end = case.nextToken().toInt()
            val time = case.nextToken().toLong()
            graph.add(Edge(start,end,time))
        }

        val result = bellmanFord(1)
        //println(dist.contentToString())
        if(result){
            println(-1)
        }else{
            for(d in 2..N){
                if(dist[d] == MAX) println(-1)
                else println(dist[d])
            }
        }
    }
}