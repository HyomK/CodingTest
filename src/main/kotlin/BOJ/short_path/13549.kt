package BOJ.short_path

import java.util.LinkedList
import java.util.StringTokenizer

fun main(){
    _13549().solution()
}

class _13549 {
    fun solution () = with(System.`in`.bufferedReader()){
        val st = StringTokenizer(readLine()," ")
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val MAX = 999_999_999
        val MAX_POS = 100_000
        val dist = IntArray(100001){MAX}
        val visited = BooleanArray(100001){false}

        val queue = LinkedList<Int>()

//        if(MAX_POS >= 2*a) queue.add(2*a)
//        if(a>0) queue.add(a-1)
//        if(MAX_POS >= a+1) queue.add(a+1)
        queue.add(a)
        dist[a] = 0
        while (queue.isNotEmpty()){
            val cur = queue.poll()
           // println("$cur -> ${dist[cur]}")

            if(visited[cur]) continue
            visited[cur] = true

            if( MAX_POS >= 2*cur  ){
                dist[2*cur] = Math.min(dist[cur],dist[2*cur])
                queue.add(2*cur)
            }
            if(cur>0 ){
                dist[cur-1] = Math.min(dist[cur]+1,dist[cur-1])
                queue.add(cur-1)
            }
            if(MAX_POS >= cur+1 ){
                dist[cur+1] =  Math.min(dist[cur]+1,dist[cur+1])
                queue.add(cur+1)
            }

        }
        println(dist[b])
    }
}