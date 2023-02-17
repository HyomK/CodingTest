package BOJ.greedy

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

fun main(){
    P16953().solution()
}

class P16953 {
    val queue  = LinkedList<Pair<Long,Int>>()
    var a :Long = 0
    var b : Long = 0
    var cnt = 0

    fun bfs(start : Long){
        var flag = false
        while (queue.isNotEmpty()){
            val cur = queue.poll()
            cnt = cur.second

            if(cur.first==b){
                flag = true
                break
            }

            if(cur.first *2<=b) queue.add(Pair(cur.first*2, cur.second+1))
            val num = (cur.first.toString()+"1").toLong()
            if (num <=b) queue.add(Pair(num,cur.second+1))
           // println(queue)

        }
        if(flag) println(cnt+1)
        else println(-1)
    }

    fun solution () = with(System.`in`.bufferedReader()){
        val st = StringTokenizer(readLine()," ")
        a = st.nextToken().toLong()
        b = st.nextToken().toLong()

        queue.add(Pair(a,0))
        bfs(a)

    }
}