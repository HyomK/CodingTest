import java.util.*

fun main(){
    _18352().solution()
}

class _18352{
    val MAX = 999_999_999


    private data class Node(val nodeNum : Int, val weight: Int) : Comparable<Node>{
        override fun compareTo(other: Node): Int {
            return weight - other.weight
        }
    }

    fun solution()=with(System.`in`.bufferedReader()){
        val input = readLine().split(" ").map{it.toInt()}
        val N = input[0]
        val M = input[1]
        val K = input[2]
        val start = input[3]

        val map = Array(N+1){Vector<Node>()}
        val route =IntArray(N+1){MAX}
        val visited = BooleanArray(N+1){false}
        val queue : PriorityQueue<Node> = PriorityQueue();


        for(i in 1..M){
            val br = readLine().split(" ").map{it.toInt()}
            map[br[0]].add(Node(br[1],1))
        }
        route[start]=0

        if(map[start].size>0) queue.add(Node(start,0))

        while(queue.isNotEmpty()){
            val cur = queue.poll()
            if(visited[cur.nodeNum]) continue

            for(vertex in map[cur.nodeNum]){
                val cost = route[cur.nodeNum] + vertex.weight
                if( cost < route[vertex.nodeNum]){
                    route[vertex.nodeNum] = cost
                    queue.add(Node(vertex.nodeNum,cost))
                }
            }

        }

        val result = LinkedList<Int>()

        for(dist in route.indices){
            if(route[dist]==K) result.push(dist)
        }
        if(result.isEmpty()){
            println(-1)
            return@with
        }

        result.sort()
        for(res in result){
            println(res)
        }

    }
}